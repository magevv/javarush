package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name = "one";
        String surname = "choosen";
        int age = 20;
        boolean sex = true;
        Human teacher = new Human();
        float salary = 0.0f;

        Human() {

        };
        Human(String name) {
            this.name = name;
        }
        Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
        Human(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
        Human(String name, String surname, int age, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
        }
        Human(String name, String surname, int age, boolean sex, Human teacher) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.teacher = teacher;
        }
        Human(String name, String surname, int age, boolean sex, Human teacher, float salary) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.teacher = teacher;
            this.salary = salary;
        }
        Human(String name, String surname, int age, boolean sex, float salary) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.salary = salary;
        }
        Human(String name, int age, boolean sex, Human teacher) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.teacher = teacher;
        }
        Human(String name, String surname, float salary) {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }

    }


}
