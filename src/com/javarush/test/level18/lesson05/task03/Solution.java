package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(reader.readLine());
            FileOutputStream fos2 = new FileOutputStream(reader.readLine());
            FileOutputStream fos3 = new FileOutputStream(reader.readLine());
            if(fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                fos2.write(buffer, 0, count%2>0 ? count/2+1 : count/2);
                fos3.write(buffer, count/2, count/2);
            }

            fis.close();
            fos2.close();
            fos3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
