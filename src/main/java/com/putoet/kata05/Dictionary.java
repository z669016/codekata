package com.putoet.kata05;

import java.util.BitSet;
import java.util.List;
import java.util.function.Function;

public class Dictionary {
    private final Function<String,Integer> hash;
    private final BitSet bitset;

    public Dictionary(int size, List<String> words) {
        assert size > 2;

        bitset = new BitSet(size);
        this.hash = defaultHash(size);

        init(bitset, words, hash);
    }

    public Dictionary(int size, List<String> words, Function<String,Integer> hash) {
        assert size > 2;

        bitset = new BitSet(size);
        this.hash = hash;

        init(bitset, words, hash);
    }

    public boolean contains(String word) {
        return bitset.get(hash.apply(word));
    }

    public long bitsSet() {
        return bitset.stream().count();
    }

    private void init(BitSet bitset, List<String> words, Function<String,Integer> hashFunction) {
        int min = Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (String word : words) {
            final int hash = hashFunction.apply(word);
            if (hash < min) min = hash;
            if (hash >max) max = hash;

            bitset.set(hash);
        }
    }

    public static Function<String,Integer> defaultHash(int size) {
        return (String word) -> Math.abs(word.hashCode() % size);
    }
}
