package com.javarush.test.level14.lesson08.bonus01;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    static class MyExeption extends Exception {

    }

    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   // #1
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        // #2
        try {
            int[] num = new int[10];
            int a = num[11];

        } catch (Exception e) {
            exceptions.add(e);

        }

        // #3
        try {

            Number x = 0f;
            Double y = (Double) x;

        } catch (Exception e) {
            exceptions.add(e);

        }

        // #4
        try {

            String a = null;

            System.out.println(a.length());

        } catch (Exception e) {

            exceptions.add(e);
        }

        // #5
        try {

            String a = "qqq";
            a.charAt(4);

        } catch (Exception e) {

            exceptions.add(e);
        }

        // #6
        try {
            Solution s = new Solution();

            throw new MyExeption();


        } catch (Exception e) {
            exceptions.add(e);

        }

        // #7
        try {

            throw new IOException("that's cool");

        } catch (Exception e) {

            exceptions.add(e);
        }

        // #8
        try {
            throw new InstantiationException();

        } catch (Exception e) {

            exceptions.add(e);
        }

        // #9
        try {

            throw new InterruptedException();

        } catch (Exception e) {
            exceptions.add(e);

        }

        // #10
        try {

            throw new EOFException();

        } catch (Exception e) {
            exceptions.add(e);

        }


    }
}
