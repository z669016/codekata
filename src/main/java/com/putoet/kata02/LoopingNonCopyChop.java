package com.putoet.kata02;

public class LoopingNonCopyChop implements BinaryChop {
    public int apply(int value, int[] search) {
        assert search != null;

        if (search.length == 0)
            return -1;

        int start = 0, end = search.length;
        while (true) {
            if (end - start == 1)
                return value == search[start] ? start : -1;

            final int middle = start + (end - start) / 2;
            if (value == search[middle])
                return middle;
            else if (value < search[middle])
                end = middle;
            else {
                start = middle;
            }
        }
    }
}
