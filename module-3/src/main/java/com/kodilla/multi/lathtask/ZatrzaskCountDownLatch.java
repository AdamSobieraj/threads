package com.kodilla.multi.lathtask;

import java.util.concurrent.CountDownLatch;

public class ZatrzaskCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ZadanieWatku(latch));
            thread.start();
        }

        latch.await();

        System.out.println("All finish.");
    }

}
