package com.putoet.kata05;

import com.putoet.resources.ResourceLines;

import java.util.List;

public class MinMax {
    private MinMax() {}

    public static void main(String[] args) {
        final List<String> words = ResourceLines.list("/words.dat");

        int min = Integer.MAX_VALUE; String minWord = "";
        int max = Integer.MIN_VALUE; String maxWord = "";
        for (String word : words) {
            final int hash = word.hashCode();
            if (hash < min) {
                min = hash;
                minWord = word;
            }
            if (hash > max) {
                max = hash;
                maxWord = word;
            }
        }
        System.out.println("Min hash code is " + min + " ('" + minWord +"')");
        System.out.println("Max hash code is " + max + " ('" + maxWord +"')");
    }
}
