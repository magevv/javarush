package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        PrintStream saved = System.out;
        System.setOut(stream);
        testString.printSomething();
        String fin = outputStream.toString();
        String[] resultArray = fin.split(" ");
        int result;
        int a = Integer.parseInt(resultArray[0]);
        int b = Integer.parseInt(resultArray[2]);
        String operation = resultArray[1];

        if (operation.equals("+")) {
            result = a + b;
        } else if (operation.equals("-")) {
            result = a - b;
        } else if (operation.equals("*")) {
            result = a * b;
        } else {
            result = 0;
        }

        System.setOut(saved);
        System.out.println(a + " " + operation + " " + b + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

