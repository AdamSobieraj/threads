package com.exchangertask;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerTask {
    public static void main(String[] args) {

        Exchanger<Book> exchanger = new Exchanger<>();

        Thread generujacyWatek = new Thread(() -> {
            try {
                String tytul = "Title number " + (new Random().nextInt(100) + 1);
                String autor = "Author number " + (new Random().nextInt(100) + 1);

                Book ksiazka = new Book(tytul, autor);
                Book wymienionaKsiazka = exchanger.exchange(ksiazka);

                System.out.println("Thread recived book: " + wymienionaKsiazka);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread odbierajacyWatek = new Thread(() -> {
            try {
                Book ksiazka = new Book("", "");
                Book wymienionaKsiazka = exchanger.exchange(ksiazka);

                System.out.println("Last book : " + wymienionaKsiazka);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        generujacyWatek.start();
        odbierajacyWatek.start();
    }
}
