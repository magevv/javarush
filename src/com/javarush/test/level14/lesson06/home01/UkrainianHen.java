package com.javarush.test.level14.lesson06.home01;

class UkrainianHen extends Hen implements Country {

    int getCountOfEggsPerMonth() {
        return 200;
    }

    String getDescription() {
        String info = super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " +  getCountOfEggsPerMonth() + " яиц в месяц.";
        return info;
    }
}
