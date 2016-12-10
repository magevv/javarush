package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file1 = args[0];
        String file2 = args[1];

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            String string;
            String[] strings;
            while (br.ready()) {

                string = br.readLine();
                strings = string.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].matches(".*\\d.*")) {
                        bw.write(strings[i] + " ");
                    }
                }
            }

            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
