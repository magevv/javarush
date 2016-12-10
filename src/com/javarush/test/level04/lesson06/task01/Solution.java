package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
//        InputStreamReader stream = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(stream);
//        String a = reader.readLine();
//        String b = reader.readLine();
//        int num1 = Integer.parseInt(a);
//        int num2 = Integer.parseInt(b);

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if (num1 < num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }
    }
}