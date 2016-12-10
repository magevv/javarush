package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            String f1 = reader.readLine();
            String f2 = reader.readLine();

            FileInputStream fis1 = new FileInputStream(f1);
            FileInputStream fis2 = new FileInputStream(f2);

            byte[] buffer1 = new byte[fis1.available()];
            fis1.read(buffer1);
            fis1.close();

            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);

            FileOutputStream fos = new FileOutputStream(f1);
            fos.write(buffer2);
            fos.write(buffer1);

            fos.close();
            fis2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
