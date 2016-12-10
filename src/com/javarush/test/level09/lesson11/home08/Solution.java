package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> array = new ArrayList<int[]>();
        int[] a = {1, 3, 4, 8, 9};
        int[] b = {354, 3453};
        int[] c = {10, 30, 40, 80};
        int[] d = {-1, -3, -4, -8, -9, -34, -78};
        int[] e = new int[0];
        array.add(a);
        array.add(b);
        array.add(c);
        array.add(d);
        array.add(e);

        return array;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
