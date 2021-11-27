package com.putoet.kata05;

import java.util.BitSet;
import java.util.List;

public class Dictionary {
    private final BitSet bitset;
    private final int size;
    private final int modulo;

    public Dictionary(int size, List<String> words) {
        assert size > 2;

        bitset = new BitSet(size);
        this.size = size;
        modulo = size;

        init(bitset, words, modulo);
    }

    public boolean contains(String word) {
        return bitset.get(hash(word, modulo));
    }

    public long bitsSet() {
        return bitset.stream().count();
    }

    private void init(BitSet bitset, List<String> words, int modulo) {
        int min = Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (String word : words) {
            final int hash = hash(word, modulo);
            if (hash < min) min = hash;
            if (hash >max) max = hash;

            bitset.set(hash);
        }
    }

    public static int hash(String word, int modulo) {
        return Math.abs(word.hashCode() % modulo);
    }
}
