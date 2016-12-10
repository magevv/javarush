package com.javarush.test.level14.lesson06.home01;

class MoldovanHen extends Hen implements Country {

    int getCountOfEggsPerMonth() {
        return 300;
    }

    String getDescription() {
        String info = super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " +  getCountOfEggsPerMonth() + " яиц в месяц.";
        return info;
    }
}
