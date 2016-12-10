package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(reader.readLine());
            FileOutputStream fos = new FileOutputStream(reader.readLine());
            if(fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                for (int i = buffer.length-1; i >= 0; i--) {
                    fos.write(buffer[i]);
                }
            }

            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
