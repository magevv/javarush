package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = reader.readLine();
            BufferedReader br  = new BufferedReader(new FileReader(fileName));
            StringBuilder s = new StringBuilder();

            while (br.ready()) {
                s.replace(0, s.length(), br.readLine());
                System.out.println(s.reverse());
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
