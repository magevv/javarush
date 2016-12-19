package com.javarush.test.level20.lesson10.bonus01;


import java.util.LinkedList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    private static boolean isCandidate(int S) {
        int lastDigit = 0;
        int currentDigit = S % 10;
        while (S > 0) {
            if (lastDigit > currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            S /= 10;
        }

        return true;
    }

    private static int[][] getMultiArray(int s) {
        int maxPow = String.valueOf(s).length();
        int[][] multi = new int[10][maxPow + 1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= maxPow; j++) {
                multi[i][j] = (int) Math.pow(i, j);
            }
        }
        return multi;
    }

    public static boolean isArmstrong(int s) {
        if (calculateSum(s) == s) {
            return true;
        }
        return false;
    }

    private static int[][] aMulti = getMultiArray(Integer.MAX_VALUE);

    private static int calculateSum(int s) {
        int pow = String.valueOf(s).length();
        int sum = 0;
        int temp = s % 10;
        while (s > 0) {
            sum += aMulti[temp][pow];
            s /= 10;
            temp = s % 10;
        }
        return sum;
    }

    public static int[] getNumbers(int N) {

        int[] result = null;

        LinkedList<Integer> list = new LinkedList<>();

        for (int S = 1; S <= N; S++) {
            if (isCandidate(S) && isArmstrong(S)) {
                list.add(S);
            }
        }

        result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.removeFirst();
        }


        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        //int[] test = getNumbers(2147467258);
        int[] test = getNumbers(21474672);

        long stopTime = System.currentTimeMillis();
        System.out.println("Calculating time: " + (stopTime - startTime) + " ms");
        System.out.println(
                "Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) +
                        " MB");


        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");

        }


    }
}