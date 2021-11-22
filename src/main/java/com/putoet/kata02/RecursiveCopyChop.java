package com.putoet.kata02;

import java.util.Arrays;

public class RecursiveCopyChop implements BinaryChop {
    public int apply(int value, int[] search) {
        assert search != null;

        if (search.length == 0)
            return -1;

        if (search.length == 1)
            return value == search[0] ? 0 : -1;

        final int middle = search.length / 2;
        if (value == search[middle])
            return middle;
        else if (value < search[middle])
            return apply(value, Arrays.copyOfRange(search, 0, middle));
        else {
            int result = apply(value, Arrays.copyOfRange(search, middle, search.length));
            return result != -1 ? result + middle : -1;
        }
    }
}
