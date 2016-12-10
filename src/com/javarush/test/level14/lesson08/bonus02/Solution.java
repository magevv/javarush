package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int div=0;

        if (x > y) {
            for (int i = y; i > 0; i--) {
                if (x%i == 0 && y%i == 0) {
                    div = i;
                    break;
                }
            }
        } else {
            for (int i = x; i > 0; i--) {
                if (x%i == 0 && y%i == 0) {
                    div = i;
                    break;
                }
            }
        }
        System.out.println(div);

    }
}
