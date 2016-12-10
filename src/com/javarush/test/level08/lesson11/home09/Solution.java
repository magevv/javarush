package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String date = "FEB 5 2014";
        System.out.println(date + " = " + isDateOdd(date));
        date = "FEB 6 2014";
        System.out.println(date + " = " + isDateOdd(date));
    }

    public static boolean isDateOdd(String date)
    {
        Date yearStart = new Date();
        yearStart.setHours(0);
        yearStart.setMinutes(0);
        yearStart.setSeconds(0);
        yearStart.setMonth(0);
        yearStart.setDate(1);
        Date d1 = new Date(date);
        long time = d1.getTime() - yearStart.getTime();
        long msDay = 1000*3600*24;
        int days = (int)(time/msDay);
        System.out.println(days);

        return days%2 != 0 ? true : false;
    }
}
