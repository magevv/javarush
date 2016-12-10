package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readFile = new BufferedReader(new FileReader(readFileName.readLine()));
            String s;
            String id = args[0];
            String[] stringArr;

            while ((s = readFile.readLine())!=null) {
                stringArr = s.split(" ", 2);

                if (id.equals(stringArr[0])) {
                    System.out.println(s);
                }

            }
            readFileName.close();
            readFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
