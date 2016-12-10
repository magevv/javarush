package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(reader.readLine());
            if (fis.available() > 0) {
                int counter = 0;
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                for (int i = 0; i < buffer.length; i++) {
                    if(buffer[i] == 44) {
                        counter++;
                    }
                }
                fis.close();
                System.out.println(counter);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
