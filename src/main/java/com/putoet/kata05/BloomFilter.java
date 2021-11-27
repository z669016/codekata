package com.putoet.kata05;

import com.putoet.resources.ResourceLines;
import org.javatuples.Pair;

import java.util.List;

public class BloomFilter {
    public static void main(String[] args) {
        final List<String> words = ResourceLines.list("/words.dat");
        filter(1_000, words);
        filter(10_000, words);
        filter(100_000, words);
        filter(1_000_000, words);
        filter(10_000_000, words);
    }

    private static void filter(int size, List<String> words) {
        final Dictionary dictionary = new Dictionary(size, words);
        System.out.println("The dictionary has " + dictionary.bitsSet() + " bits set.");

        final List<String> generated = WordGenerator.generate(size, 3, 12);
        final long positives = generated.stream()
                .map(word -> new Pair<>(word, dictionary.contains(word)))
                .filter(Pair::getValue1)
                // .peek(System.out::println)
                .count();

        System.out.println("Testing with a Bloom filter with " + size + " bits gives " + positives +
                " positive matches (" + (int)(positives * 100 / size) + "%).");
    }
}
