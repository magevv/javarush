package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> f1 = new ArrayList<String>();
    public static List<String> f2 = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            String s;

            while (br1.ready()) {
                f1.add(br1.readLine());
            }

            while ((br2.ready())) {
                f2.add(br2.readLine());
            }
            
/*            for (int i = 0; i < f1.size(); i++) {
                if(f2.contains(f1.get(i))) {
                    lines.add(new LineItem(Type.SAME, f1.get(i)));
                } else {
                    lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                }
            }

            for (int i = 0; i < f2.size(); i++) {
                if(!f1.contains(f2.get(i))) {
                    lines.add(new LineItem(Type.ADDED, f2.get(i)));
                }
            }*/


            for (LineItem li : lines) {
                System.out.println(li.type + " " + li.line);
            }

            br1.close();
            br2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
