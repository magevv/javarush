package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(reader.readLine());

        SortedSet<Integer> list = new TreeSet<Integer>();

        try {
            while (fis.available() > 0) {
                list.add(fis.read());
            }

            for (Integer x : list) {
                System.out.print(x + " ");
            }

            fis.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
