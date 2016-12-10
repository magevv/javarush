package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            load(new FileInputStream(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties p = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            p.setProperty(entry.getKey(), entry.getValue());
        }
        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        properties.clear();
        Properties p = new Properties();
        p.load(inputStream);
        for(String key : p.stringPropertyNames()) {
            String value = p.getProperty(key);
            properties.put(key, value);
        }
    }


}
