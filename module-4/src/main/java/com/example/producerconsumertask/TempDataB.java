package com.example.producerconsumertask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TempDataB {
    private List<Customer> customers = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void insert(Customer customer) {
        lock.writeLock().lock();
        try {
            customers.add(customer);
            System.out.println("Inserted: " + customer.getName());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Customer select(int index) {
        lock.readLock().lock();
        try {
            return customers.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }
}
