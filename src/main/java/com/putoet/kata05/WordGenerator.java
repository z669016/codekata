package com.putoet.kata05;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordGenerator {
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'";
    private WordGenerator() {}

    public static List<String> generate(int size, int minLen, int maxLen) {
        assert minLen > 0;
        assert maxLen >= minLen;

        return IntStream.range(0, size)
                .mapToObj(i -> WordGenerator.generate(minLen, maxLen))
                .collect(Collectors.toList());
    }

    private static String generate(int minLen, int maxLen) {
        return generate(minLen) + generate(random(maxLen - minLen));

    }

    private static String generate(int len) {
        return IntStream.range(0, len)
                .mapToObj(i -> WordGenerator.generate())
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));

    }

    private static char generate() {
        return CHARS.charAt(random(CHARS.length()));
    }

    private static int random(int max) {
        return (int) (Math.random() * max);
    }

    public static void main(String[] args) {
        final List<String> generated = WordGenerator.generate(10, 3,15);
        generated.forEach(System.out::println);
    }
}
