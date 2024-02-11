package com.kodilla.multi.multi;

public class Multi {

    private int counter = 1;

    public synchronized void multi(int value) {
        counter *= value;
    }

    public int getCounter() {
        return counter;
    }
}
