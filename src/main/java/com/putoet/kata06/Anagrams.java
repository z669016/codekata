package com.putoet.kata06;

import java.util.*;
import java.util.stream.Collector;

public class Anagrams {
    private final Map<String, Set<String>> anagrams = new HashMap<>();

    public Map<String, Set<String>> anagrams() {
        return anagrams;
    }

    public boolean add(String word) {
        final String key = asKey(word);
        final Set<String> set = anagrams.computeIfAbsent(key, k -> new HashSet<>());
        return set.add(word);
    }

    public static String asKey(String word) {
        assert word != null;

        return word
                .chars()
                .sorted()
                .mapToObj(i -> (char) i)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }
}
