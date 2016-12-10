package com.javarush.test.level06.lesson05.task02;

/* Классы Cat и Dog и метод finalize для каждого
В каждом классе Cat и Dog написать метод finalize, который выводит на экран текст о том, что такой-то объект уничтожен.
*/

public class Cat
{
    String name = "Vaska";
    protected void finalize() throws Throwable {
        System.out.println("Object " + this + " destroyed");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            Cat cat = new Cat();
        }
    }

}

class Dog
{   String name = "Bobik";
    protected void finalize() throws Throwable {
        System.out.println("Object " + name + " destroyed");
    }

}