package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));

            String s;

            while(br.ready()) {
                s = br.readLine().replaceAll("\\.", "!");
                bw.write(s);
                bw.newLine();
            }

            bw.flush();
            br.close();
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
