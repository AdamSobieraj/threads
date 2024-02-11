package com.kodilla.multi.simple;

import com.kodilla.multi.multi.Multi;
import com.kodilla.multi.multi.PartialCalcMulti;
//import com.kodilla.multi.sum.PartialCalc;
//import com.kodilla.multi.sum.Reducer;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        int[] anArray = new int[10];
        for (int n = 0; n < anArray.length; n++) {
            anArray[n] = n + 1;
        }

        Multi multi = new Multi();

        PartialCalcMulti p1 = new PartialCalcMulti(multi, anArray, 0, 5);
        PartialCalcMulti p2 = new PartialCalcMulti(multi, anArray, 5, anArray.length);

        p1.start();
        p2.start();

        p1.join();
        p2.join();

        System.out.println(multi.getCounter());
    }

// option 3
//    public static void main(String[] args) throws InterruptedException {
//
//        int[] anArray = new int[1000];
//        for (int n = 0; n < anArray.length; n++) {
//            anArray[n] = 1;
//        }
//
//        Reducer reducer = new Reducer();
//
//        PartialCalc p1 = new PartialCalc(reducer, anArray, 0, 500);
//        PartialCalc p2 = new PartialCalc(reducer, anArray, 500, anArray.length);
//
//        p1.start();
//        p2.start();
//
//        p1.join();
//        p2.join();
//
//        System.out.println(reducer.getCounter());
//    }


// opcja 2
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new CounterRunnable());
//        Thread t2 = new Thread(new CounterRunnable());
//        t1.start();
//        t2.start();
//    }


// opcja 1
//    public static void main(String[] args) {
//        Counter c1 = new Counter();
//        Counter c2 = new Counter();
//
//        c1.start();
//        c2.start();
//    }

}
