package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Solution o = new Solution();

        if(a<o.max(a, b, c) && a>o.min(a, b, c))  {
            System.out.println(a);
        }
        else if(b<o.max(a, b, c) && b>o.min(a, b, c)) {
            System.out.println(b);
        }
        else {
            System.out.println(c);
        }


    }

    public int min(int a, int b, int c) {
        int x;
        if(a<b && a<c) x = a;
        else if(b<a && b<c) x = b;
        else x = c;
        return x;
    }

    public int max(int a, int b, int c) {
        int x;
        if(a>b && a>c) x = a;
        else if(b>a && b>c) x = b;
        else x = c;
        return x;
    }

}
