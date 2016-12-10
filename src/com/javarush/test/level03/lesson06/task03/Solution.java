package com.javarush.test.level03.lesson06.task03;

/* Семь цветов радуги
Выведи на экран текст: семь цветов радуги.
В каждой строке должно быть по три цвета, в последней - один.
Цвета разделяй пробелом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        String[] rainbow = {"Красный","Оранжевый","Желтый","Зеленый","Голубой","Синий","Фиолетовый"};
        for (int i = 0; i < 7; i++)
        {
            if(i!=2 && i!=5) System.out.print(rainbow[i]+" ");
            else System.out.println(rainbow[i]+" ");
        }

    }
}