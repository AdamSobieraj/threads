package com.exchangertask;

class Book {
    private String tytul;
    private String autor;

    public Book(String tytul, String autor) {
        this.tytul = tytul;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book{" +
                " title ='" + tytul + '\'' +
                ", autor ='" + autor + '\'' +
                '}';
    }
}
