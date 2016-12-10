package com.javarush.test.level18.lesson08.task04;

import java.io.IOException;

/**
 * Created by Администратор on 10.02.2015.
 */
public class Main {

    public static void main(String[] args) {
        try {
            new TxtInputStream("c:/1.txt");
        } catch (UnsupportedFileNameException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
