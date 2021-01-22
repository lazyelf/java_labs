package com.lazyelf.storage;


import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
    Scanner in = new Scanner(System.in);
    Storage storage = new Storage(in);

    @Before
    public void init() {
        String s1 = "1 10 70 1 2 15 70 1 3 20 70 1 4 10 50 1 ";
        Scanner inF = new Scanner(s1);
        storage.setIn(inF);
        for (int i = 0; i < 4; ++i) {
            storage.addFlower();
        }

        String s2 = "1 30 1 2 13 9";
        Scanner inL = new Scanner(s2);
        storage.setIn(inL);
        for (int i = 0; i < 2; ++i) {
            storage.addLeaf();
        }

        String s3 = "Basket\n30\nStone\n40\n";
        Scanner inD = new Scanner(s3);
        storage.setIn(inD);
        for (int i = 0; i < 2; ++i) {
            storage.addDecoration();
        }
    }

    @Test
    public void createBouquetTest() throws IOException {
        String s = "B2\n1 2 3\n1\n1\n";
        Scanner in = new Scanner(s);
        storage.setIn(in);
        storage.createBouquet();
        PrintStream out = System.out;
        String name = "/home/_lazyelf/_Main/Java_projects/Complex/src/test/java/com/lazyelf/storage/OutStorageTest.txt";
        System.setOut(new PrintStream(name));
        storage.showBouquets();
        System.setOut(out);
        String expected = "\t\tList of bouquets:\n" +
                "\t\t1. Bouquet B2 with price 229.0\n" +
                "\t\t\t\tFlowers:\n" +
                "\t\t\t\t\t1. Flower red Carnation with length 70 with button size 10 price - 24.0\n" +
                "\t\t\t\t\t2. Flower while Chamomile with length 70 with button size 15 price - 29.0\n" +
                "\t\t\t\t\t3. Flower wine Chrysanthemum with length 70 with button size 20 price - 136.0\n" +
                "\t\t\t\tLeaves:\n" +
                "\t\t\t\t\t1. Leaf green Fern with length 30 price - 10.0\n" +
                "\t\t\t\tDecorations:\n" +
                "\t\t\t\t\t1. Decoration Basket price - 30.0\n\n";

        assertEquals(expected, Files.readString(Path.of(name)));
    }


    @Test
    public void checkRemoveFlower() {
        storage.removeFlower(1);
        String s = "Carnation";
        assertFalse(storage.toString().contains(s));
    }

    @Test
    public void checkRemoveLeaf() {
        storage.removeLeaf(1);
        String s = "Fern";
        assertFalse(storage.toString().contains(s));
    }

    @Test
    public void checkRemoveDecoration() {
        storage.removeDecoration(1);
        String s = "Basket";
        assertFalse(storage.toString().contains(s));
    }

    @Test
    public void checkRemoveBouquet() {
        String s1 = "B2\n1 2 3\n1\n1\n";
        Scanner in1 = new Scanner(s1);
        storage.setIn(in1);
        storage.createBouquet();
        storage.removeBouquet(1);
        String s = "B1";
        assertFalse(storage.toString().contains(s));
    }
}