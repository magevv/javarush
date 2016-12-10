package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    public Money(double amount)
    {
        this.money = amount;
    }
    public Money() {
        this(0);
    }



    protected double money;

    public double getAmount() {
        return money;
    }

    public abstract String getCurrencyName();
}

