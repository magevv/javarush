package com.javarush.test.level14.lesson06.home01;

class BelarusianHen extends Hen implements Country {

    int getCountOfEggsPerMonth() {
        return 400;
    }

    String getDescription() {
        String info = super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " +  getCountOfEggsPerMonth() + " яиц в месяц.";
        return info;
    }
}
