package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        SortedMap<String, Double> map = new TreeMap<String, Double>();

        try {
            BufferedReader br  = new BufferedReader(new FileReader(fileName));
            String[] parsedString;
            String key;
            double value;
            while (br.ready()) {
                parsedString = br.readLine().split(" ");
                key = parsedString[0];
                value = Double.parseDouble(parsedString[1]);

                if (!map.keySet().contains(key)) {
                    map.put(key, value);
                } else {
                    value = value + map.get(key);
                    map.put(key, value);
                }
            }

            double max = getMax(map);

            for (SortedMap.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    System.out.println(entry.getKey());
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getMax(Map<String, Double> map) {
        double max = 0;
        for (SortedMap.Entry<String, Double> entry : map.entrySet()) {
            max = entry.getValue() > max ? entry.getValue() : max;
        }
        return max;
    }

}
