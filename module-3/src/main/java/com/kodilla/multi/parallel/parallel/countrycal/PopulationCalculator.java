package com.kodilla.multi.parallel.parallel.countrycal;

import java.util.List;
import java.util.concurrent.RecursiveTask;

class PopulationCalculator extends RecursiveTask<Long> {
    private static final int THRESHOLD =  10;
    private List<Country> countries;
    private int start;
    private int end;

    public PopulationCalculator(List<Country> countries, int start, int end) {
        this.countries = countries;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long total =  0;
            for (int i = start; i < end; i++) {
                total += countries.get(i).getPeopleQuantity();
            }
            return total;
        } else {
            int mid = (start + end) /  2;
            PopulationCalculator left = new PopulationCalculator(countries, start, mid);
            PopulationCalculator right = new PopulationCalculator(countries, mid, end);
            invokeAll(left, right);
            return left.join() + right.join();
        }
    }
}
