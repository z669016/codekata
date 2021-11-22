package com.putoet.kata02;

import java.util.Arrays;

public class BuildInChop implements BinaryChop {
    public int apply(int value, int[] search) {
        assert search != null;

        int result = Arrays.binarySearch(search, value) ;
        return result >= 0 ? result : -1;
    }
}
