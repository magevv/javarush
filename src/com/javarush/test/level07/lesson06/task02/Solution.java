package com.javarush.test.level07.lesson06.task02;

/* 5 строчек: «101», «102», «103», «104», «105»
1. Создай список строк.
2. Добавь в него 5 строчек: «101», «102», «103», «104», «105».
3. Удали первую, среднюю и последнюю.
4. Используя цикл выведи на экран его содержимое, каждое значение с новой строки.
5. Выведи его размер. (После удаления одного элемента индексы остальных меняются.
Например, если удалить 0-й элемент, то тот, который был 1-м, станет 0-м. И т.д.)
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add("101");
        a.add("102");
        a.add("103");
        a.add("104");
        a.add("105");
        a.remove(0);
        a.remove((a.size()-1) / 2);
        a.remove(a.size()-1);

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        System.out.println(a.size());

    }
}
