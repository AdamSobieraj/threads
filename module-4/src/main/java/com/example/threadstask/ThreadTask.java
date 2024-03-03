package com.example.threadstask;

public class ThreadTask {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: HI !");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: HI !");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All dead");
    }
}
