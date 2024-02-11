package com.kodilla.multi.multi;

import com.kodilla.multi.sum.Reducer;

public class PartialCalcMulti extends Thread {
    private Multi multi;
    private int[] elements;
    private int lowerIndex;
    private int upperIndex;

    public PartialCalcMulti(Multi multi, int[] elements, int lowerIndex, int upperIndex) {
        this.multi = multi;
        this.elements = elements;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }

    @Override
    public void run() {
        for (int n = lowerIndex; n < upperIndex; n++) {
            multi.multi(elements[n]);
        }
    }

}
