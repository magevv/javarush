package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран надпись: таблицу умножения 10 на 10:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        int mt = 0;
        for (int i = 1; i < 11; i++)
        {
            for (int j = 1; j < 11; j++)
            {
                mt = i*j;
                System.out.print(mt + "\u0009");
            }
            System.out.println();
        }

    }
}