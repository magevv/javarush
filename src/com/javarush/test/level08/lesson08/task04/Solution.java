package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Норрис", new Date("OCTOBER 1 1980"));
        map.put("Шварц", new Date("JULY 1 1980"));
        map.put("Ли", new Date("APRIL 1 1980"));
        map.put("Чан", new Date("JULY 1 1980"));
        map.put("Уиллис", new Date("MARCH 1 1980"));
        map.put("Бобер", new Date("AUGUST 1 1980"));
        map.put("Рудер", new Date("DECEMBER 1 1980"));
        map.put("Гамильтон", new Date("JULY 1 1980"));
        map.put("Иден", new Date("JUNE 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> copy = new HashMap<String, Date>(map);
        for (Map.Entry<String, Date> pair : copy.entrySet()) {
            int value = pair.getValue().getMonth();
            if(value >= 5 && value <=7) map.remove(pair.getKey());


        }

    }

    public static void main(String[] args) {
       HashMap<String, Date> people = createMap();
        System.out.println(people);
        removeAllSummerPeople(people);
        System.out.println(people);
    }
}
