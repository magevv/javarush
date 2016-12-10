package com.javarush.test.level03.lesson06.task04;

/* Путь к файлу java.exe
Выведи на экран текст: полное имя файла java.exe из установленного пакета java
*/



public class Solution
{
    public static void main(String[] args)
    {

        //String jhome = System.getProperty("java.home");
        //String jexe = "\\java.exe";
        String j = "c:\\Program Files\\Java\\jdk1.7.0\\bin\\java.exe";
        System.out.println(j);
    }
}