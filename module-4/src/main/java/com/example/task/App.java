package com.example.task;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        CompletableFuture<List<String>> service1 = CompletableFuture.supplyAsync(() -> List.of("A", "B", "C"));
        CompletableFuture<List<String>> service2 = CompletableFuture.supplyAsync(() -> List.of("B", "C", "D"));

        CompletableFuture<List<String>> combinedWithoutDuplicates = service1.thenCompose(list1 ->
                service2.thenApply(list2 -> {
                    List<String> combined = Stream.concat(list1.stream(), list2.stream())
                            .collect(Collectors.toList());
                    return combined.stream().distinct().collect(Collectors.toList());
                }));

        // Wyświetlenie wyniku
        combinedWithoutDuplicates.thenAccept(System.out::println);

        // Czekanie na zakończenie wszystkich operacji
        combinedWithoutDuplicates.join();
    }
}
