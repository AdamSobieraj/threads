package com.kodilla.multi.parallel.parallel.countrycal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class WorldPopulation {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Poland",  38298000));
        countries.add(new Country("Germany",  83166711));
        countries.add(new Country("France",  67186638));
        countries.add(new Country("Poland1",  38298000));
        countries.add(new Country("Germany1",  83166711));
        countries.add(new Country("France1",  67186638));
        countries.add(new Country("Poland2",  38298000));
        countries.add(new Country("Germany2",  83166711));
        countries.add(new Country("France2",  67186638));
        countries.add(new Country("Poland3",  38298000));
        countries.add(new Country("Germany3",  83166711));
        countries.add(new Country("France3",  67186638));

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        PopulationCalculator task = new PopulationCalculator(countries,  0, countries.size());
        long worldPopulation = forkJoinPool.invoke(task);
        System.out.println("World population: " + worldPopulation);
    }
}
