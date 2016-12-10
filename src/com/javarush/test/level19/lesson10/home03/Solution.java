package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        String fileName = args[0];

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String[] s;
            Calendar cal = Calendar.getInstance();
            Date birthday;
            int year, month, day;

            while (br.ready()) {
                StringBuilder name = new StringBuilder("");
                s = br.readLine().split(" ");
                year = Integer.parseInt(s[s.length-1]);
                month = Integer.parseInt(s[s.length-2])-1;
                day = Integer.parseInt(s[s.length-3]);
                cal.set(year, month, day);
                birthday = cal.getTime();

                for (int i = 0; i < s.length-3; i++) {
                    if (i != s.length-4) {
                        name.append(s[i]).append(" ");
                    } else {
                        name.append(s[i]);
                    }
                }
                PEOPLE.add(new Person(name.toString(), birthday));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
