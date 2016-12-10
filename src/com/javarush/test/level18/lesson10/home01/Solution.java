package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
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
                if ( (buffer[i] >= 60 && buffer[i] <= 90) || (buffer[i] >= 97 && buffer[i] <= 122)) {
                    lettersCount++;
                }
            }
            System.out.println(lettersCount);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
