package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Yuriy on 26.01.2017.
 */
public class Hippodrome {

    public ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance() ) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {

        game = new Hippodrome();
        ArrayList<Horse> horses = game.getHorses();
        horses.add(new Horse("Harry", 3, 0));
        horses.add(new Horse("Ron", 3, 0));
        horses.add(new Horse("Hermione", 3, 0));
        game.run();
        game.printWinner();

    }
}
