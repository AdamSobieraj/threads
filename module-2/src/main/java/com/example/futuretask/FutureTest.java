package com.example.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.example.util.SleepUtil.sleep;


public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Processor processor = new Processor();
        final Future<Integer> futureResultA = processor.process(2, 10, "process A");
        final Future<Integer> futureResultB = processor.process(3, 5, "process B");

        while (!futureResultA.isDone() || !futureResultB.isDone()) {
            System.out.println("Doing something else");
            sleep(1);
        }

        final Integer resultA = futureResultA.get();
        final Integer resultB = futureResultB.get();
        System.out.println("ResultA " + resultA);
        System.out.println("ResultB " + resultB);
    }
}
