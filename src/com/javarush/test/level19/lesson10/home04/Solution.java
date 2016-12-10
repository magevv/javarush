package com.javarush.test.level19.lesson10.home04;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String initialString;
            String[] s;
            while (br.ready()) {
                initialString = br.readLine();
                s = initialString.replaceAll("\\p{Punct}", " ").split(" ");
                if (compareWords(words, s) == 2) {
                    System.out.println(initialString);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int compareWords(List<String> words, String[] string) {
        ArrayList<String> match = new ArrayList<String>();
        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < words.size(); j++) {
                if (string[i].equals(words.get(j))) {
                    match.add(string[i]);
                }
            }
        }
            return match.size();
    }
}
