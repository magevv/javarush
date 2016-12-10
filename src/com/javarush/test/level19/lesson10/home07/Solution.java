package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        String file1 = args[0];
        String file2 = args[1];

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            ArrayList<String> arr = new ArrayList<>();
            String string;
            String[] strings;
            while (br.ready()) {

                string = br.readLine();
                strings = string.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].length() > 6) {
                        arr.add(strings[i] + ",");
                    }
                }
            }

            // delete comma at the end
            arr.set(arr.size()-1, arr.get(arr.size()-1).replaceAll(",", ""));
            for (String x : arr) {
                bw.write(x);
            }

            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
