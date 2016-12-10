package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter writeFile = new BufferedWriter(new FileWriter(reader.readLine()));

            String[] s = readFile.readLine().split(" ");
            readFile.close();
            StringBuffer sb = new StringBuffer();

            for (String x : s) {
                sb.append(Math.round(Double.parseDouble(x))).append(" ");
            }

            writeFile.write(sb.toString());
            writeFile.flush();
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
