package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tag = args[0];
        String gat = new StringBuilder(tag).reverse().toString();

        try {
            String file1 = reader.readLine();
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            StringBuilder sb = new StringBuilder("");
            String s;
            String sReverse;

            while (br1.ready()) {
                sb.append((char)br1.read());
            }

            s = sb.toString().replaceAll("\r\n", " ");
            sReverse = sb.reverse().toString().replaceAll("\n\r", " ");

            Pattern p = Pattern.compile("(<\\s*" + tag + "[^><]*>.*<\\s*/\\s*" + tag + "\\s*>)", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(s);

            Pattern openTag = Pattern.compile("<\\s*" + tag + "[^><]*>", Pattern.CASE_INSENSITIVE);
            Matcher mOpenTag = openTag.matcher(s);

            Pattern closeTag = Pattern.compile(">\\s*" + gat + "\\s*/\\s*<", Pattern.CASE_INSENSITIVE);
            Matcher mCloseTag = closeTag.matcher(sReverse);

            int lastIndex = 0;
            int firstIndex = 0;

            System.out.println(s);
            System.out.println(sReverse);

            while (mOpenTag.find() && mCloseTag.find()) {

                if (m.find(mOpenTag.start())) {
                    firstIndex = mOpenTag.start();
                    lastIndex = s.length() - mCloseTag.start();

                    System.out.println(s.substring(firstIndex, lastIndex));
                }

            }



            br1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
