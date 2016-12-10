package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        String line;

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            line = "";
            while ( ( line = reader1.readLine()) != null ) {
                allLines.add(line);
            }
            reader1.close();

            line = "";
            while ( ( line = reader2.readLine()) != null ) {
                forRemoveLines.add(line);
            }
            reader2.close();

        } catch (IOException e) {
            /*NOP*/
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            /*NOP*/
        }

    }

    public void joinData () throws CorruptedDataException {
        boolean hasLine;
        for (String x : forRemoveLines) {
            hasLine = false;
            for (String y : allLines) {
                if (y.equals(x)) {
                    hasLine = true;
                }
            }
            if (!hasLine) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        allLines.removeAll(forRemoveLines);
        for (String x : allLines) {
            System.out.println(x);
        }

    }
}
