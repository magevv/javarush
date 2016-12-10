package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(reader.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        try {
            int x;
            while (fis.available() > 0) {
                x = fis.read();
                map.put(x, map.get(x)!=null ? map.get(x)+1 : 1);
            }

            int min = map.entrySet().iterator().next().getValue();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (min > entry.getValue()) {
                    min = entry.getValue();
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == min) {
                    System.out.println(entry.getKey());
                }
            }

            fis.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
