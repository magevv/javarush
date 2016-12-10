package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        PrintStream saved = System.out;
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            OutputStreamWriter bw = new OutputStreamWriter(new FileOutputStream(reader.readLine()));
            bw.write(result);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setOut(saved);
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

