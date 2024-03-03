package com.barriertask;

import java.util.concurrent.CyclicBarrier;

public class BarrierTask {

    public static void main(String[] args) {
        CyclicBarrier bariera = new CyclicBarrier(5);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ZadanieWatku(bariera));
            thread.start();
        }

        try {
            bariera.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All stop !");
    }
}
