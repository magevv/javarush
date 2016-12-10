package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children = new ArrayList<Human>();

        Human child1 = new Human("Назар", true, 5);
        Human child2 = new Human("Юна", false, 2);
        Human child3 = new Human("Муна", false, 7);

        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human father = new Human("Юра", true, 32, children);
        Human mother = new Human("Лариса", true, 30, children);

        ArrayList<Human> children2 = new ArrayList<Human>();
        ArrayList<Human> children3 = new ArrayList<Human>();

        children2.add(father);
        children3.add(mother);

        Human grandfather1 = new Human("Георгий", true, 73, children2);
        Human grandfather2 = new Human("Василий", true, 71, children3);
        Human grandmother1 = new Human("Надя", true, 70, children2);
        Human grandmother2 = new Human("Маша", true, 69, children3);

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(grandfather1.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother2.toString());
    }

    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, Boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this. children = children;
        }

        public Human(String name, Boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
