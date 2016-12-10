package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String[] splittedString = s.split("");

        String s1 = splittedString[1].toUpperCase();

        for (int i = 2; i < splittedString.length; i++) {
            if (splittedString[i-1].equals(" ")) {
                splittedString[i] = splittedString[i].toUpperCase();
            }

            s1 = s1.concat(splittedString[i]);

        }

        System.out.println(s1);

    }

}
