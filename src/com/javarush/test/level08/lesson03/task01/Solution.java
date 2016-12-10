package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<String> plants = new HashSet<String>();

        plants.add("арбуз");
        plants.add("банан");
        plants.add("вишня");
        plants.add("груша");
        plants.add("дыня");
        plants.add("ежевика");
        plants.add("жень-шень");
        plants.add("земляника");
        plants.add("ирис");
        plants.add("картофель");

        Iterator<String> iterator = plants.iterator(); // get the iterator for set

        while (iterator.hasNext()) {  // verify if there are remained elements
            System.out.println(iterator.next());  // get the current element and switch to the next element
        }


    }
}
