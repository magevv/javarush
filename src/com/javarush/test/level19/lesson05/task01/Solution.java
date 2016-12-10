package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileReader fr = new FileReader(reader.readLine());
            FileWriter fw = new FileWriter(reader.readLine());
            int i = 1;
            int ch;
            while (fr.ready()) {
                ch = fr.read();
                if (i%2 == 0) {
                    fw.write(ch);
                }
                i++;
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
