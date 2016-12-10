package com.javarush.test.level14.lesson08.home09;

public class USD extends Money {

    public USD(double amount) {
    this.money = amount;
}
    public USD() {
        super();
    }



    public String getCurrencyName() {
        return "USD";
    }
}
