package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s;
            while (!(s = reader.readLine()).equals("exit")) {
                new ReadThread(s).run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int max = 1;

            try {
                FileInputStream fis = new FileInputStream(fileName);
                int x;
                while (fis.available() > 0) {
                    x = fis.read();
                    map.put(x, map.get(x)!=null ? map.get(x)+1 : 1);
                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    max = max < entry.getValue() ? entry.getValue() : max;
                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (max == entry.getValue()) {
                        resultMap.put(fileName, entry.getKey());
                    }
                }

                fis.close();

            } catch(IOException e) {
                e.printStackTrace();
            }
        }



    }
}
