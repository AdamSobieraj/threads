package com.kodilla.multi.parallel.parallel.countrycal;

class Country {

    private String name;
    private long peopleQuantity;

    public Country(String name, long peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    public long getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getName() {
        return name;
    }
}
