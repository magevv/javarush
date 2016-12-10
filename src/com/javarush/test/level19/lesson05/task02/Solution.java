package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileReader fr = new FileReader(reader.readLine());
            BufferedReader br = new BufferedReader(fr);
            int count = 0;
            String s;
            String[] ss;

            while(br.ready()) {
                s = br.readLine().replaceAll("\\p{Punct}", " ");
                ss = s.split(" ");
                for (int i = 0; i < ss.length; i++) {
                    if (ss[i].equals("world")) {
                        count++;
                    }

                }
            }


            System.out.println(count);
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
