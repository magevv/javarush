package com.javarush.test.level08.lesson06.task01;

import java.util.*;

/* Создать два списка LinkedList и ArrayList
Нужно создать два списка – LinkedList и ArrayList.
*/

public class Solution
{
    public static Object createArrayList()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        return list;

    }

    public static Object createLinkedList()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        return list;

    }

    public static void main(String[] args) {
        Object linkedList = createLinkedList();
        Object arrayList = createArrayList();
    }
}
