package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();

        InputStream file = new FileInputStream(fileName);
        while (file.available() > 0) {
            char data = (char) file.read();
            System.out.print(data);
        }

        file.close();
    }
}
