package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        if(args[0].equals("-e")) {
            try {
                FileInputStream fis = new FileInputStream(args[1]);
                FileOutputStream fos = new FileOutputStream(args[2]);
                int b;

                while (fis.available() > 0) {
                    b = fis.read();
                    fos.write(b + 1);
                }

                fis.close();
                fos.flush();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(args[0].equals("-d")) {
            try {
                FileInputStream fis = new FileInputStream(args[1]);
                FileOutputStream fos = new FileOutputStream(args[2]);
                int b;

                while (fis.available() > 0) {
                    b = fis.read();
                    fos.write(b - 1);
                }

                fis.close();
                fos.flush();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
