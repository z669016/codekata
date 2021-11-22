package com.putoet.kata02;

public class RecursiveNonCopyChop implements BinaryChop {
    public int apply(int value, int[] search) {
        return apply(value, search, 0, search.length);
    }

    public int apply(int value, int[] search, int start, int end) {
        assert search != null;

        if (search.length == 0)
            return -1;

        if (end - start == 1)
            return value == search[start] ? start : -1;

        final int middle = start + (end - start) / 2;
        if (value == search[middle])
            return middle;
        else if (value < search[middle])
            return apply(value, search, start, middle);
        else
            return apply(value, search, middle, end);
    }
}
