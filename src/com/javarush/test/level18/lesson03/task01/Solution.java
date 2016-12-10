package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(reader.readLine());
        try {
            int max = 0;
            int byt;
            while (fis.available()>0) {
                byt = fis.read();
                if (max < byt) {
                    max = byt;
                }
            }
            System.out.println(max);
            fis.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
