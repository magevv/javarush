package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(reader.readLine());
        try {
            int min = fis.read();
            int byt;
            while (fis.available()>0) {
                byt = fis.read();
                if (min > byt) {
                    min = byt;
                }
            }
            System.out.println(min);
            fis.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
