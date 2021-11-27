package com.putoet.kata06;

import org.apache.commons.math3.stat.inference.OneWayAnova;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramsTest {

    @Test
    void asKey() {
        assertEquals("a", Anagrams.asKey("a"));
        assertEquals("ab", Anagrams.asKey("ba"));
        assertEquals("aabc", Anagrams.asKey("baca"));
        assertEquals("eellp", Anagrams.asKey("lepel"));
    }

    @Test
    void anagrams() {
        final Set<String> words = Set.of(
                "kinship", "pinkish",
                "enlist", "inlets", "listen", "silent",
                "boaster", "boaters", "borates",
                "fresher", "refresh",
                "sinks", "skins",
                "knits", "stink",
                "rots", "sort"
        );

        final Anagrams anagrams = new Anagrams();
        for (String word: words) anagrams.add(word);

        anagrams.anagrams().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}