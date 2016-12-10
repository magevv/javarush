package com.javarush.test.level10.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() throws Exception
    {
        ArrayList<String>[] arr = new ArrayList[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

       for (int i = 0; i < arr.length; i++) {
            while(true) {
                String a = reader.readLine();
                if (a.isEmpty()) break;
                list.add(a);
            }
            arr[i] = list;
        }

        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}