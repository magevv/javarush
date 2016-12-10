package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        map.put("name1", new Cat("name1"));
        map.put("name2", new Cat("name2"));
        map.put("name3", new Cat("name3"));
        map.put("name4", new Cat("name4"));
        map.put("name5", new Cat("name5"));
        map.put("name6", new Cat("name6"));
        map.put("name7", new Cat("name7"));
        map.put("name8", new Cat("name8"));
        map.put("name9", new Cat("name9"));
        map.put("name10", new Cat("name10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set = new HashSet<Cat>();
        for(Map.Entry<String, Cat> x : map.entrySet()) {
            set.add(x.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
