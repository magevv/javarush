package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null, new File("c:/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            //petrov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.name.equals(somePerson.name)) {
                System.out.println("It's the same person!");
            } else {
                System.out.println("They are different people...");
            }
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();
        public String assetExists;

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream ps = new PrintStream(outputStream);
            ps.print(name + "|");
            assetExists = (assets != null) ? assets.size()+"|" : "0|";
            ps.print(assetExists);
            if (assets != null) {
                for (Asset a : assets) {
                    ps.print(a.getName()+"|");
                    ps.print(a.getPrice()+"|");
                }
            }
            ps.println();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String s = br.readLine();
            String[] sArray = s.split("\\|");
            Asset asset;
            this.name = sArray[0];
            this.assetExists = sArray[1];
            if (!assetExists.equals("0")) {
                for (int i = 2; i < sArray.length;) {
                    asset = new Asset(sArray[i]);
                    asset.setPrice(Double.parseDouble("0.0"));
                    this.assets.add(asset);
                    i = i + 2;
                }
            }
        }
    }
}
