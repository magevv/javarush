package com.javarush.test.level20.lesson10.home07;

import java.io.*;
import java.util.Arrays;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String file;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.file = fileName;

    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(file);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        file = (String)in.readObject();
        stream = new FileOutputStream(file, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public FileOutputStream getStream() {return this.stream;}

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName = "file";

        Solution sol1 = new Solution(fileName);
        sol1.writeObject("AA");

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("java"));
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("java"));
        FileInputStream fistest = new FileInputStream(fileName);

        System.out.println(fistest.available());

        os.writeObject(sol1);

        Solution sol2 = (Solution)is.readObject();

        sol2.writeObject("BB");

        System.out.println(fistest.available());

        //file content
        BufferedInputStream oostest = new BufferedInputStream(fistest);
        while (oostest.available() > 0) {
            char c = (char)oostest.read();
            System.out.print(c);
        }
    }
}
