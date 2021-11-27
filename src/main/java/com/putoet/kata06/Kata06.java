package com.putoet.kata06;

import com.putoet.resources.ResourceLines;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Kata06 {
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();

        final List<String> words = ResourceLines.list("/anagrams.dat");
        final Anagrams anagrams = new Anagrams();

        words.forEach(anagrams::add);
        final long end = System.currentTimeMillis();
        System.out.println("Words processed in " + (end - start) + " ms");

        final long setCount = anagrams.anagrams().entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .count();
        System.out.println("Number of anagram sets found is " + setCount);

        final long count = anagrams.anagrams().values().stream()
                .filter(set -> set.size() > 1)
                .mapToInt(Set::size)
                .sum();
        System.out.println("Number of anagrams found is " + count);

        anagrams.anagrams().entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .ifPresentOrElse(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()), () -> System.out.println("No anagrams found"));

        anagrams.anagrams().entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .max(Comparator.comparing(entry -> entry.getKey().length()))
                .ifPresentOrElse(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()), () -> System.out.println("No anagrams found"));
    }
}
