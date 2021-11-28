package com.putoet.kata02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryChopTest {
    private BinaryChop chop;

    @Test
    void loopingCopyChop() {
        chop = new LoopingCopyChop();
        testChop();
    }

    @Test
    void recursiveCopyChop() {
        chop = new RecursiveCopyChop();
        testChop();
    }

    @Test
    void loopingNonCopyChop() {
        chop = new LoopingNonCopyChop();
        testChop();
    }

    @Test
    void recursiveNonCopyChop() {
        chop = new RecursiveNonCopyChop();
        testChop();
    }

    @Test
    void BuildInChop() {
        chop = new BuildInChop();
        testChop();
    }

    void testChop() {
        assertEquals(-1, chop.apply(3, new int[] {}));
        assertEquals(-1, chop.apply(3, new int[] {1}));
        assertEquals(0, chop.apply(1, new int[] {1}));

        assertEquals(0, chop.apply(1, new int[] {1, 3, 5}));
        assertEquals(1, chop.apply(3, new int[] {1, 3, 5}));
        assertEquals(2, chop.apply(5, new int[] {1, 3, 5}));
        assertEquals(-1, chop.apply(0, new int[] {1, 3, 5}));
        assertEquals(-1, chop.apply(2, new int[] {1, 3, 5}));
        assertEquals(-1, chop.apply(4, new int[] {1, 3, 5}));
        assertEquals(-1, chop.apply(6, new int[] {1, 3, 5}));

        assertEquals(0, chop.apply(1, new int[] {1, 3, 5, 7}));
        assertEquals(1, chop.apply(3, new int[] {1, 3, 5, 7}));
        assertEquals(2, chop.apply(5, new int[] {1, 3, 5, 7}));
        assertEquals(3, chop.apply(7, new int[] {1, 3, 5, 7}));
        assertEquals(-1, chop.apply(0, new int[] {1, 3, 5, 7}));
        assertEquals(-1, chop.apply(2, new int[] {1, 3, 5, 7}));
        assertEquals(-1, chop.apply(4, new int[] {1, 3, 5, 7}));
        assertEquals(-1, chop.apply(6, new int[] {1, 3, 5, 7}));
        assertEquals(-1, chop.apply(8, new int[] {1, 3, 5, 7}));
    }
}