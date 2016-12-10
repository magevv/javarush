package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            FileOutputStream fos1 = new FileOutputStream(reader.readLine());
            FileInputStream fis2 = new FileInputStream(reader.readLine());
            FileInputStream fis3 = new FileInputStream(reader.readLine());

            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);
            fos1.write(buffer2);

            byte[] buffer3 = new byte[fis3.available()];
            fis3.read(buffer3);
            fos1.write(buffer3);

            fos1.close();
            fis2.close();
            fis3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
