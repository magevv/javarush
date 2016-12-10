package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals("-c")) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            String productName = ajustString(args[1], 30);
            String price = ajustString(args[2], 8);
            String quantity = ajustString(args[3], 4);

            ArrayList<String> list = new ArrayList<String>();
            BufferedReader readFile = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = readFile.readLine()) != null) {
                list.add(s);
            }
            readFile.close();

            int max = 0;
            int id;
            for (String x : list) {
                id = Integer.parseInt(x.substring(0, 8).trim());
                max = max < id ? id : max;
            }

            String result = ajustString(String.valueOf(max + 1), 8) + productName + price + quantity;

            BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName, true));

            writeFile.write(result+"\n");

            writeFile.flush();
            writeFile.close();
        }
    }



    public static String ajustString(String parameter, int maxLength) {
        StringBuilder str = new StringBuilder(parameter);
        int length = str.length();
        if(length < maxLength) {
            for (int i = 0; i < maxLength - length; i++) {
                str.append(" ");
            }
        } else {
            str.delete(maxLength, length);
        }
        return str.toString();
    }
}
