package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            int lettersCount = 0;
            for (int i = 0; i < count; i++) {
                if (buffer[i] == 32) {
                    lettersCount++;
                }
            }

            System.out.println(round((double)lettersCount/count*100, 2));
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}

