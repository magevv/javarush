package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Козлов","Иван");
        map.put("Иванов","Сергей");
        map.put("Сидоров","Вова");
        map.put("Пупкин","Вася");
        map.put("Петров","Вася");
        map.put("Васечкин","Петя");
        map.put("Шукшин","Коля");
        map.put("Тихоновский","Вова");
        map.put("Гезь","Иван");
        map.put("Друзь","Александр");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if(pair.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if(pair.getKey().equals(familiya)) count++;
        }
        return count;

    }


    public static void main(String[] args) {
        HashMap<String, String> dic = createMap();
        //System.out.println(dic);
        System.out.println(getCountTheSameFirstName(dic, "Иван"));
        System.out.println(getCountTheSameLastName(dic, "Петров"));
    }

}
