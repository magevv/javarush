package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("java"));
        Person person = new Person("Yuriy", "Popsuenko", "Ukraine", Sex.MALE);
        System.out.println(person.greetingString);
        System.out.println(person.firstName + person.lastName + person.country + person.sex);
        System.out.println(person.logger);
        os.writeObject(person);
        os.flush();
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("java"));
        Person newPerson = (Person)is.readObject();
        System.out.println("--------------------------------------------");
        System.out.println(newPerson.greetingString);
        System.out.println(newPerson.firstName + newPerson.lastName + newPerson.country + newPerson.sex);
        System.out.println(newPerson.logger);


    }

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
