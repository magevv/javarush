package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
    labels.put(45.6, "red");
    labels.put((double)10, "green");
    labels.put(0.9, "blue");
    labels.put(11.111, "yellow");
    labels.put(3.14, "purple");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}
