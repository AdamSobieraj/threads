package com.barriertask;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

class ZadanieWatku implements Runnable {
    private final CyclicBarrier bariera;
    private int sumaA = 1000;
    private int sumaB = 0;
    private final Random random = new Random();

    public ZadanieWatku(CyclicBarrier bariera) {
        this.bariera = bariera;
    }

    @Override
    public void run() {
        try {
            while (sumaA > sumaB) {
                sumaA += random.nextInt(10);
                sumaB += random.nextInt(50);
                System.out.println("Thread " + Thread.currentThread().getName() + " - sum A: " + sumaA + ", sum B: " + sumaB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                bariera.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}