package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        SortedMap<Integer, String> map = new TreeMap<Integer, String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        try {

            FileInputStream fis;
            String[] array;
            StringBuilder resultFileName = new StringBuilder("");
            byte[] buffer = new byte[1000];

            while (!(s = reader.readLine()).equals("end")) {
                array = s.split("\\.part+");
                resultFileName.replace(0, array[0].length(), array[0]);
                map.put(Integer.parseInt(array[1]), s);
            }

            FileOutputStream fos = new FileOutputStream(resultFileName.toString());

            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                fis = new FileInputStream(entry.getValue());
                int counter = 0;
                while (fis.available() > 0) {
                    counter = fis.read(buffer);
                    fos.write(buffer, 0, counter);
                }
                fis.close();
            }
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
