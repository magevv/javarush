package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        try {

            SortedMap<Byte,Integer> map = new TreeMap<Byte,Integer>();

            FileInputStream fis = new FileInputStream(args[0]);

            byte ch;

            while (fis.available() > 0) {
                ch = (byte)fis.read();
                map.put(ch, map.get(ch)!=null ? map.get(ch)+1 : 1);
            }

            for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    System.out.println((char)((byte)entry.getKey()) + " " + entry.getValue());
            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
