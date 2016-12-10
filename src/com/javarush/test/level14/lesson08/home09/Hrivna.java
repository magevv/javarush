package com.javarush.test.level14.lesson08.home09;

public class Hrivna extends Money {

    public Hrivna(double amount) {
        this.money = amount;
    }

    public Hrivna() {
        super();
    }

    public String getCurrencyName() {
        return "HRN";
    }

}
