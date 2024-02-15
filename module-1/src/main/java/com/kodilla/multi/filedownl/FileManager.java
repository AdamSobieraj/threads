package com.kodilla.multi.filedownl;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class FileManager implements Runnable {

    private static int counter;
    private static Semaphore semaphore = new Semaphore(10);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void download() throws InterruptedException {
        Random random = new Random();
        synchronized (FileManager.class) {
            counter++;
            System.out.println("There are currently  " + counter + " filed downloaded");
        }
        Thread.sleep(random.nextInt(100));
        synchronized (FileManager.class) {
            counter--;
        }
    }
}


