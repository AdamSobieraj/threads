package com.kodilla.multi.executormulti;

import com.kodilla.multi.executor.Task;

import java.util.Random;

public class TaskMulti implements Runnable {

    private static int counter;

    @Override
    public void run() {
        taskBody();
    }

    private void taskBody() {

        int[] array1 = {1,  2,  3};
        int[] array2 = {4,  5,  6};

        long[] resultArray = new long[array1.length];

        for (int i =  0; i < array1.length; i++) {
            resultArray[i] = (long) array1[i] * array2[i];
        }

        synchronized (Task.class) {

            for (long value : resultArray) {
                System.out.println(Thread.currentThread().getName() + " finished, value = " + value);
            }
        }
    }
}