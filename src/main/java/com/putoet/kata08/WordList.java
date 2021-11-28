package com.putoet.kata08;

import com.putoet.resources.ResourceLines;
import org.javatuples.Pair;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public final class WordList {
    private static final Set<String> words = ResourceLines.set("/anagrams.dat");

    private WordList() {
    }

    public static Set<String> words() {
        return Collections.unmodifiableSet(words);
    }

    public static Set<String> ofLength(int length) {
        return words.stream().filter(word -> word.length() == length).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        final List<Set<String>> words = List.of(
                WordList.ofLength(1),
                WordList.ofLength(2),
                WordList.ofLength(3),
                WordList.ofLength(4),
                WordList.ofLength(5),
                WordList.ofLength(6)
        );

        long start = System.currentTimeMillis();
        combine(words, WordList::combineStreams);
        long end = System.currentTimeMillis();
        System.out.println("Combining took " + (end - start) + " ms using streams");

        start = System.currentTimeMillis();
        combine(words, WordList::combineParallelStreams);
        end = System.currentTimeMillis();
        System.out.println("Combining took " + (end - start) + " ms using parallel streams");
    }

    private static void combine(List<Set<String>> words, BiFunction<Pair<Set<String>, Set<String>>, Set<String>, List<Pair<String, String>>> combine) {
        final Set<String> oneLetterWords = words.get(0);
        final Set<String> twoLetterWords = words.get(1);
        final Set<String> threeLetterWords = words.get(2);
        final Set<String> fourLetterWords = words.get(3);
        final Set<String> fiveLetterWords = words.get(4);
        final Set<String> sixLetterWords = words.get(5);

        combine(oneLetterWords, fiveLetterWords, sixLetterWords, combine);
        combine(twoLetterWords, fourLetterWords, sixLetterWords, combine);
        combine(threeLetterWords, threeLetterWords, sixLetterWords, combine);
        combine(fourLetterWords, twoLetterWords, sixLetterWords, combine);
        combine(fiveLetterWords, oneLetterWords, sixLetterWords, combine);
    }

    private static void combine(final Set<String> first, final Set<String> second, final Set<String> target,
                                BiFunction<Pair<Set<String>, Set<String>>, Set<String>, List<Pair<String, String>>> combine) {
        final List<Pair<String, String>> combinations = combine.apply(Pair.with(first, second), target);
        // combinations.forEach(pair -> System.out.printf("%s + %s => %s%n", pair.getValue0(), pair.getValue1(), pair.getValue0() + pair.getValue1()));
    }

    private static List<Pair<String, String>> combineStreams(Pair<Set<String>, Set<String>> sets, Set<String> target) {
        return sets.getValue0().stream()
                .map(firstWord -> sets.getValue1().stream()
                        .filter(secondWord -> target.contains(firstWord + secondWord))
                        .map(secondWord -> new Pair<>(firstWord, secondWord))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Pair<String, String>> combineParallelStreams(Pair<Set<String>, Set<String>> sets, Set<String> target) {
        return sets.getValue0().parallelStream()
                .map(firstWord -> sets.getValue1().parallelStream()
                        .filter(secondWord -> target.contains(firstWord + secondWord))
                        .map(secondWord -> new Pair<>(firstWord, secondWord))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
