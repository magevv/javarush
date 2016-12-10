package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));

            ArrayList<String> a = new ArrayList();

            String s;
            String[] ss;

            while(br.ready()) {
                s = br.readLine().replaceAll("\\p{Punct}", " ");
                ss = s.split(" ");
                for (int i = 0; i < ss.length; i++) {
                    if (ss[i].matches("[0-9]+")) {
                        a.add(ss[i]);
                    }
                }
            }

            for (String x : a) {
                bw.write(x + " ");
            }

            bw.flush();
            br.close();
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
