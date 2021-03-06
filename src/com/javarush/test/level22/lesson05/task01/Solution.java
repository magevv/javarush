package com.javarush.test.level22.lesson05.task01;


/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) {

        if (string == null || string.split(" ").length < 5) {
            throw new TooShortStringException();
        }
        int start = string.indexOf(" ");
        int pointer = start;
        int end = pointer;

        for (int i = 0; i < 4; i++) {
            pointer = string.indexOf(" ", pointer + 1);
            if (pointer != -1) {
                end = pointer;
            } else {
                end = string.length();
            }
        }

        return string.substring(start + 1, end);
    }

    public static class TooShortStringException extends RuntimeException {

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
