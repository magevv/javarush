package com.javarush.test.level03.lesson04.task01;

/* Дата рождения
Вывести на экран дату своего рождения в виде: MAY 1 2012
*/


import java.text.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        String myBirthday = "1982-02-02"; // input date
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd"); // object to parse the string into date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d yyyy"); // object to format date
        Date t;

        try
        {
            t = ft.parse(myBirthday); // parsing the string into date
            System.out.print(dateFormat.format(t)); // formatting the date

        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}