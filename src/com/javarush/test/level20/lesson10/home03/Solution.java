package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";
        public A() {}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream os) throws IOException {
            os.defaultWriteObject();
            os.writeObject(name);
        }

        private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
            is.defaultReadObject();
            this.name = (String)is.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("java.ser"));
        B b = new Solution().new B("x");
        System.out.println(b.name);
        os.writeObject(b);
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("java.ser"));
        B bb = (B)is.readObject();
        System.out.println(bb.name);
    }
}
