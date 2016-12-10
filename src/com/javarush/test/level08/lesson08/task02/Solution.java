package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> num = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            num.add(i*2-4);
        }
        return num;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {

        HashSet<Integer> copy = new HashSet<Integer>(set);
        Iterator<Integer> iterator = copy.iterator();
        while(iterator.hasNext()) {
            int x = iterator.next();
            if (x > 10) {
               set.remove(x);
            }
        }
        return set;

    }

    public static void main(String[] args) {
        HashSet<Integer> set = createSet();
        System.out.println(set);

        Set<Integer> num = removeAllNumbersMoreThan10(set);
        System.out.println(num);

    }

}
