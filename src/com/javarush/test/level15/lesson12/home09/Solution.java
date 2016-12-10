package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String[] urlParam = url.split("\\?")[1].split("\\&");

        String[] p;

        for (String x : urlParam) {

            System.out.print(x.split("=")[0] + " ");

        }

        System.out.println("");

        for (String x : urlParam) {

            if ( (p = x.split("="))[0].equals("obj")  ) {

                try {
                    alert(Double.parseDouble(p[1]));
                } catch (NumberFormatException e) {
                    alert(p[1]);
                }

            }

        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
