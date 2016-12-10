package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static String sexToString(Sex sex) {
        if (sex == sex.MALE) {
            return "м";
        } else {
            return "ж";
        }
    }

    public static Sex stringToSex(String s) {
        Sex sex;
        if (s.equals("м")) {
            sex = Sex.MALE;
        } else {
            sex = Sex.FEMALE;
        }
        return sex;
    }

    public static void main(String[] args) {

        // person's parameters
        int id;
        Person person;
        String name;
        String sex;
        String date;

        SimpleDateFormat dateOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);


                if(args.length == 4 && args[0].equals("-c")) {            // create
                    try {
                    if(args[2].equals("м")) {
                        allPeople.add(Person.createMale(args[1], dateInput.parse(args[3])));
                        System.out.println(allPeople.size()-1);
                    } else if(args[2].equals("ж")) {
                        allPeople.add(Person.createFemale(args[1], dateInput.parse(args[3])));
                        System.out.println(allPeople.size()-1);
                    }

                } catch (ParseException e) {
                        System.out.println("Wrong date format");
                }


                } else if (args.length == 5 && args[0].equals("-u")) {    // update
                    try {
                        id = Integer.parseInt(args[1]);
                        person = allPeople.get(id);
                        person.setName(args[2]);
                        person.setSex(stringToSex(args[3]));
                        try {
                            person.setBirthDay(dateInput.parse(args[4]));
                        }catch (ParseException e) {
                            System.out.println("Wrong date format");
                        }

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index does not exist");
                    }

                } else if (args.length == 2 && args[0].equals("-d")) {    // delete
                    try {
                        id = Integer.parseInt(args[1]);
                        allPeople.remove(id);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index does not exist");
                    }

                } else if (args.length == 2 && args[0].equals("-i")) {    // info
                    try {
                        id = Integer.parseInt(args[1]);
                        person = allPeople.get(id);
                        name = person.getName();
                        sex = sexToString(person.getSex());
                        date = dateOutput.format(person.getBirthDay());
                        System.out.println(name + " " + sex + " " + date);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index does not exist");
                    }

                } else {
                    System.out.println("Wrong parameters");
                }

    }
}
