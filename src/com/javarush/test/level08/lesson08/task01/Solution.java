package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("Лес");
        set.add("Лето");
        set.add("Лось");
        set.add("Любовь");
        set.add("Луч");
        set.add("Люк");
        set.add("Лом");
        set.add("Легенда");
        set.add("Люстра");
        set.add("Люстрация");
        set.add("Лежать");
        set.add("Лететь");
        set.add("Лелеять");
        set.add("Лубок");
        set.add("Лариса");
        set.add("Лапоть");
        set.add("Лепить");
        set.add("Любить");
        set.add("Лесть");
        set.add("Лысый");

        return set;
    }
}
