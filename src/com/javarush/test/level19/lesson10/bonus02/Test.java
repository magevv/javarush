package com.javarush.test.level19.lesson10.bonus02;

import java.io.IOException;

/**
 * Created by Администратор on 01.03.2015.
 */
public class Test {

    public static void main(String[] args) {
        try {
            String s = "012345";
            FileConsoleWriter fcw = new FileConsoleWriter("c:/1.txt");
            fcw.append(s);
            fcw.flush();
            fcw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
