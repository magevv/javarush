package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner sc;
        public PersonScannerAdapter(Scanner sc) {
            this.sc = sc;
        }

        @Override
        public void close() throws IOException {
            sc.close();
        }

        @Override
        public Person read() throws IOException {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            Calendar c = Calendar.getInstance();
            c.set(Integer.parseInt(arr[5]), Integer.parseInt(arr[4])-1, Integer.parseInt(arr[3]));
            return new Person(arr[1], arr[2], arr[0], c.getTime());
        }
    }
}
