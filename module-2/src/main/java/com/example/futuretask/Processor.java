package com.example.futuretask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.example.util.SleepUtil.sleep;

public class Processor {

    public Future<Integer> process(int x, int time, String proccesId) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Processor started processing: " + proccesId);
            sleep(time);
            System.out.println("Processor ended processing: " + proccesId);
            return x * 1000;
        });
    }
}
