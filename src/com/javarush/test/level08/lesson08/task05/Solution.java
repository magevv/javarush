package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Иванов","Иван");
        map.put("Козлов","Иван");
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String,String> pair : copy.entrySet()) {
            String value = pair.getValue();
            String key = pair.getKey();

            for (Map.Entry<String,String> pair2 : copy.entrySet()) {
                String key2 = pair2.getKey();
                String value2 = pair2.getValue();
                if (!key.equals(key2) && value.equals(value2)) removeItemFromMapByValue(map, value);
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> people = createMap();
        removeTheFirstNameDuplicates(people);
        System.out.println(people);
    }
}

