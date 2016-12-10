package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man chuck = new Man("Chuck", 45, "New York");
        Man arnie = new Man("Arnold", 56, "Washington");
        Woman sintia = new Woman("Sintia", 34, "London");
        Woman julia = new Woman("Julia", 25, "Kyiv");

        System.out.println(chuck.name + " " + chuck.age + " " + chuck.address);
        System.out.println(arnie.name + " " + arnie.age + " " + arnie.address);
        System.out.println(sintia.name + " " + sintia.age + " " + sintia.address);
        System.out.println(julia.name + " " + julia.age + " " + julia.address);
    }

    public static class Man {
        String name = "John";
        String address = "middle east";
        int age = 20;

        Man() {}

        Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        Man(String name, int age) {
            this.name = name;
            this.age = age;
        }

        Man(String name) {
            this.name = name;
        }

        Man(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }

    public static class Woman extends Man {

        Woman() {
            super();
        }

        Woman(String name, int age, String address) {
            super(name, age, address);
        }

        Woman(String name, int age) {
            super(name, age);
        }

        Woman(String name) {
            super(name);
        }

        Woman(String name, String address) {
            super(name, address);
        }
    }
    
}
