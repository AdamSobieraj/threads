package com.example.completable.homework;

public class Book {
    private String title;
    private String author;
    private int year;
    private String signature;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.signature = ""; // Pole podpisu jest na początku zawsze puste
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getSignature() {
        return signature;
    }

    public void signBook(String signature) {
        this.signature = signature;
    }

    public void displayContent() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Signature: " + signature);
    }
}
