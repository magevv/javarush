package com.javarush.test.level14.lesson06.home01;

class RussianHen extends Hen implements Country {

    int getCountOfEggsPerMonth() {
        return 100;
    }

    String getDescription() {
        String info = super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " +  getCountOfEggsPerMonth() + " яиц в месяц.";
        return info;
    }

}

