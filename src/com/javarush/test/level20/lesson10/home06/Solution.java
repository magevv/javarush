package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream os) throws IOException {


            throw new NotSerializableException();


        }

        private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {

            throw new NotSerializableException();
        }


    }

    public static void main(String[] args) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("java"));
        SubSolution test = new SubSolution();
        os.writeObject(test);

    }
}
