package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null, new File("c:/Javarush"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User a = new User();
            a.setFirstName("Yura");
            a.setLastName("Popsuenko");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            a.setBirthDate(sdf.parse("1982-02-02"));
            a.setMale(true);
            a.setCountry(User.Country.UKRAINE);
            javaRush.users.add(a);

            User b = new User();
            b.setFirstName("Ira");
            javaRush.users.add(b);

            javaRush.save(outputStream);

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.get(0).getFirstName());
            System.out.println(loadedObject.users.get(0).getBirthDate());


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream ps = new PrintStream(outputStream);
            if(users != null) {
                ps.println(users.size());
                for (User u : users) {
                    ps.println( (u.getFirstName() != null ? u.getFirstName() : "default" ) + "|"
                              + (u.getLastName() != null ? u.getLastName() : "default" )  + "|"
                              + (u.getBirthDate() != null ? (outputDateFormat.format(u.getBirthDate())) : "1970-01-01" ) + "|"
                              + (u.isMale() ? "true" : "false") + "|"
                              + (u.getCountry() != null ? u.getCountry().getDisplayedName() : User.Country.OTHER)
                    );
                }
            } else ps.println(0);
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String[] s;
            User u;
            String userExist;
            while(br.ready()) {
                userExist = br.readLine();
                if (!userExist.equals("0")) {
                    for (int i = 0; i < Integer.parseInt(userExist); i++) {
                        s = br.readLine().split("\\|");
                        u = new User();
                        u.setFirstName(s[0]);
                        u.setLastName(s[1]);
                        u.setBirthDate(outputDateFormat.parse(s[2]));
                        u.setMale(s[3].equals("true"));
                        for(User.Country e : User.Country.values()) {
                            if (e.getDisplayedName().equals(s[4])) {
                                u.setCountry(e);
                                break;
                            }
                        }
                    users.add(u);
                    }
                }
            }

        }
    }
}
