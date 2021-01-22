package com.lazyelf.storage.bouquetsComponents;


import org.junit.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DecorationTest {

    @Test
    public void checkingDecorationString() {
        String s = "Basket\n30\n";
        Scanner in = new Scanner(s);
        Decoration d1 = new Decoration(in);
        assertEquals("Decoration Basket price - 30.0", d1.toString());
    }

    @Test
    public void checkingDecorationPrice() {
        String s = "Stone\n40\n";
        Scanner in = new Scanner(s);
        Decoration d2 = new Decoration(in);
        assertEquals(40, d2.getPrice());
    }

}