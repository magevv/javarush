package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static void print(int x) {
        System.out.println(x);
    }
    public static void print(int x, int y) {
        System.out.println(x+y);
    }
    public static void print(String x) {
        System.out.println(x);
    }
    public static void print(String s, int x) {
        System.out.println(s+x);
    }
    public static void print(boolean x) {
        System.out.println(x);
    }
}
