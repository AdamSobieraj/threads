package com.example.completable.homework;

import java.util.concurrent.CompletableFuture;

import static com.example.util.SleepUtil.sleep;

public class CompletableBook {

    public static void main(String[] args) {
        CompletableFuture<Book> futureBook = CompletableFuture.supplyAsync(() -> {
            sleep(4);
            return new Book("Java Programming", "John Doe",  2023);
        });

        futureBook.thenAccept(book -> {
            // Etap podpisania
            book.signBook("Signed by John Doe");
            book.displayContent();
        });

        futureBook.join();
    }
}
