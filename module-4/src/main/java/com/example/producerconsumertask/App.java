package com.example.producerconsumertask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        TempDataB database = new TempDataB();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            database.insert(new Customer("Lord V"));
        });

        executorService.submit(() -> {
            database.insert(new Customer("Lord V2"));
        });

        executorService.submit(() -> {
            Customer customer = database.select(0);
            System.out.println("Selected: " + customer.getName());
        });

        executorService.submit(() -> {
            Customer customer = database.select(1);
            System.out.println("Selected: " + customer.getName());
        });

        executorService.shutdown();
    }
}
