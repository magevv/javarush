package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> fileData = new ArrayList<String>();

        String fileName = sc.next();
        OutputStream file = new FileOutputStream(fileName);

        /*while (true) {
            String string = sc.next();
            if (string.equals("exit")) {
                fileData.add(string);
                break;
            }
            fileData.add(string);
        }*/

        String string;
        while(!(string = sc.next()).equals("exit")) {
            fileData.add(string);
        }
        fileData.add(string);

        for (String x : fileData) {
            file.write((x+"\r\n").getBytes());
        }

        file.close();
    }
}
