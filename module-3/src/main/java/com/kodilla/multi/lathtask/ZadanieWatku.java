package com.kodilla.multi.lathtask;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

class ZadanieWatku implements Runnable {
    private final CountDownLatch latch;
    private final Random random = new Random();

    public ZadanieWatku(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int delay = random.nextInt(1501) + 500;
            Thread.sleep(delay);
            System.out.println("Thread " +
                    Thread.currentThread().getName() +
                    " finished after delay " +
                    delay + " ms.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            latch.countDown();
        }
    }
}
