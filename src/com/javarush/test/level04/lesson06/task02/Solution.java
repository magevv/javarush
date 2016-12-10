package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        Solution s = new Solution();
        int n1 = s.max(a, b);
        int n2 = s.max(c, d);
        int n3 = s.max(n1, n2);

        System.out.println(n3);

    }

    public static int max(int x, int y) {
        int z = 0;
        if(x > y) {
            z = x;
        } else {
            z = y;
        }
        return z;
    }

}
