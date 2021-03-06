package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            for (SortedMap.Entry<String, Double> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
