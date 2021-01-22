package com.lazyelf.storage.bouquetsComponents.leaves;


import org.junit.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class LeafTest {

    @Test
    public void checkingFern() {
        String s = "30 1";
        Scanner in = new Scanner(s);
        Fern l1 = new Fern(in);
        assertEquals(10, l1.getPrice());
    }

    @Test
    public void checkingLavender() {
        String s = "13 9";
        Scanner in = new Scanner(s);
        Lavender l2 = new Lavender(in);
        assertEquals(8, l2.getPrice());
    }

    @Test
    public void checkingPalm() {
        String s = "30 1";
        Scanner in = new Scanner(s);
        Palm l3 = new Palm(in);
        assertEquals(12, l3.getPrice());
    }

    @Test
    public void checkingTree() {
        String s = "30 1";
        Scanner in = new Scanner(s);
        Tree l4 = new Tree(in);
        assertEquals(4, l4.getPrice());
    }
}