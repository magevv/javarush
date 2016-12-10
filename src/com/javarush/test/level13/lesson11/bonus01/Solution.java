package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // load file with entered name to stream
        BufferedReader reader = new BufferedReader(new FileReader(sc.next()));

        // read file by lines
        String line;
        while ((line = reader.readLine()) != null) {

            numbers.add(Integer.parseInt(line));
        }

        // sort array
        int temp;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size()-1; j++) {
                if(numbers.get(j) > numbers.get(j+1)) {
                    temp = numbers.get(j);
                    numbers.set(j, numbers.get(j+1));
                    numbers.set(j+1, temp);
                }
            }
        }

        for(Integer x : numbers) {
            if (x%2 == 0) {
                System.out.println(x);
            }

        }


    }
}
