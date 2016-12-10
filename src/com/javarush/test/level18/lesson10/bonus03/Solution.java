package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<String>();

        if (args[0].equals("-u")) {

            try {
                BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
                String fileName = readFileName.readLine();
                BufferedReader readFile = new BufferedReader(new FileReader(fileName));


                String productName = ajustString(args[2], 30);
                String price = ajustString(args[3], 8);
                String quantity = ajustString(args[4], 4);
                String id = ajustString(args[1], 8);

                String result = id + productName + price + quantity;

                String s;
                while ((s = readFile.readLine()) != null) {
                    array.add(s);
                }

                readFileName.close();
                readFile.close();

                for (int i = 0; i < array.size(); i++) {
                    if (Integer.parseInt(id.trim()) == Integer.parseInt(array.get(i).substring(0, 8).trim())) {
                        array.set(i, result);
                    }
                }

                PrintWriter pw = new PrintWriter(new FileWriter(fileName));

                for (String x : array) {
                    pw.println(x);
                }

                pw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        if (args[0].equals("-d")) {

            try {
                BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
                String fileName = readFileName.readLine();
                BufferedReader readFile = new BufferedReader(new FileReader(fileName));

                String id = ajustString(args[1], 8);

                String s;
                while ((s = readFile.readLine()) != null) {
                    array.add(s);
                }

                readFileName.close();
                readFile.close();

                for (int i = 0; i < array.size(); i++) {
                    if (Integer.parseInt(id.trim()) == Integer.parseInt(array.get(i).substring(0, 8).trim())) {
                        array.remove(i);
                    }
                }

                PrintWriter pw = new PrintWriter(new FileWriter(fileName));

                for (String x : array) {
                    pw.println(x);
                }

                pw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public static String ajustString(String parameter, int maxLength) {
        StringBuilder str = new StringBuilder(parameter);
        int length = str.length();
        if(length < maxLength) {
            for (int i = 0; i < maxLength - length; i++) {
                str.append(" ");
            }
        } else {
            str.delete(maxLength, length);
        }
        return str.toString();
    }
}
