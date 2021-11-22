package com.putoet.kata02;

import java.util.Arrays;

public class LoopingCopyChop implements BinaryChop {
    public int apply(int value, int[] search) {
        assert search != null;

        if (search.length == 0)
            return -1;

        int chopped = 0;
        int[] list = Arrays.copyOf(search, search.length);
        while (true) {
            if (list.length == 1)
                return value == list[0] ? chopped : -1;

            final int middle = list.length / 2;
            if (value == list[middle])
                return middle + chopped;
            else if (value < list[middle])
                list = Arrays.copyOfRange(list,0, middle);
            else {
                list = Arrays.copyOfRange(list, middle, list.length);
                chopped += middle;
            }
        }
    }
}
