package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {

    private FileOutputStream fos;

    public AmigoOutputStream(FileOutputStream fos) throws IOException {
        super(fileName);
        this.fos = fos;
    }



    @Override
    public void write(int i) throws IOException {
        fos.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        fos.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i2) throws IOException {
        fos.write(bytes, i, i2);
    }

    @Override
    public void close() throws IOException {
        fos.flush();
        fos.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        fos.close();
    }

    @Override
    public FileChannel getChannel() {
        return fos.getChannel();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }

    public static String fileName = "C:/tmp/result.txt";


    public static void main(String[] args) throws IOException {
       new AmigoOutputStream(new FileOutputStream(fileName));

    }

}



