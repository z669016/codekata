package com.putoet.kata03;

public class HowBig {
    public static void main(String[] args) {
        System.out.println(bitsFor(1_000L));
        System.out.println(bitsFor(1_000_000L));
        System.out.println(bitsFor(1_000_000_000L));
        System.out.println(bitsFor(1_000_000_000_000L));
        System.out.println(bitsFor(8_000_000_000_000L));

        System.out.println(Math.pow(96, 16) / 3_600_000);
    }

    private static String bitsFor(long value) {
        return "Bits for " + value + " is " + Long.toBinaryString(value).length() + " (" + Long.toBinaryString(value) + ")";
    }
}
