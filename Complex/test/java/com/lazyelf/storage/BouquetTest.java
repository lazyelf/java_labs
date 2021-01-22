package com.lazyelf.storage;

import com.lazyelf.menu.setContent.CreateBouquetCommand;
import com.lazyelf.storage.bouquetsComponents.Decoration;
import com.lazyelf.storage.bouquetsComponents.flowers.*;
import com.lazyelf.storage.bouquetsComponents.leaves.Fern;
import com.lazyelf.storage.bouquetsComponents.leaves.Lavender;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class BouquetTest {
    Scanner in = new Scanner(System.in);
    Bouquet bouquet = new Bouquet("Test Bouquet", in);

    @Before
    public void init() {
        String s1 = "10 70 1 15 70 1 20 70 1 10 50 1 ";
        Scanner inF = new Scanner(s1);
        bouquet.addFlower(new Carnation(inF));
        bouquet.addFlower(new Chamomile(inF));
        bouquet.addFlower(new Chrysanthemum(inF));
        bouquet.addFlower(new Orchid(inF));

        String s2 = "30 1 13 9";
        Scanner inL = new Scanner(s2);
        bouquet.addLeaf(new Fern(inL));
        bouquet.addLeaf(new Lavender(inL));


        String s3 = "Basket\n30\nStone\n40\n";
        Scanner inD = new Scanner(s3);
        bouquet.addDecoration(new Decoration(inD));
        bouquet.addDecoration(new Decoration(inD));

    }

    @Test
    public void checkEmpty() {
        Bouquet b = new Bouquet("B1", in);
        assertFalse(b.isNotEmpty());
    }

    @Test
    public void checkNotEmpty() {
        assertTrue(bouquet.isNotEmpty());
    }

    @Test
    public void checkRemoveFlower() {
        bouquet.removeFlower(1);
        String s = "Carnation";
        assertFalse(bouquet.toString().contains(s));
    }

    @Test
    public void checkRemoveLeaf() {
        bouquet.removeLeaf(1);
        String s = "Fern";
        assertFalse(bouquet.toString().contains(s));
    }

    @Test
    public void checkRemoveDecoration() {
        bouquet.removeDecoration(1);
        String s = "Basket";
        assertFalse(bouquet.toString().contains(s));
    }

    @Test
    public void checkPrice() {
        assertEquals(350.34, bouquet.getValue());
    }

    @Test
    public void checkOutByLength() throws FileNotFoundException {
        PrintStream out = System.out;
        String name = "/home/_lazyelf/_Main/Java_projects/Complex/src/test/java/com/lazyelf/storage/OutTest.txt";
        System.setOut(new PrintStream(name));
        String s = "40 60";
        bouquet.setIn(new Scanner(s));
        bouquet.findFlowerByLength();
        Scanner in = new Scanner(new FileInputStream(name));
        s = in.nextLine();
        System.setOut(out);
        assertEquals("\t\t\tEnter range of flower length: \t\t\tFlower wine Orchid with length 50 with button size 10 price - 73.33333333333334", s);
    }

    @Test
    public void checkOutBySize() throws FileNotFoundException {
        PrintStream out = System.out;
        String name = "/home/_lazyelf/_Main/Java_projects/Complex/src/test/java/com/lazyelf/storage/OutTest.txt";
        System.setOut(new PrintStream(name));
        String s = "16 25";
        bouquet.setIn(new Scanner(s));
        bouquet.findFlowerByButtonSize();
        Scanner in = new Scanner(new FileInputStream(name));
        s = in.nextLine();
        System.setOut(out);
        assertEquals("\t\t\tEnter range of flower button size: \t\t\tFlower wine Chrysanthemum with length 70 with button size 20 price - 136.0", s);
    }

    @Test
    public void checkFlowerChangeEmpty() throws FileNotFoundException {
        PrintStream out = System.out;
        String name = "/home/_lazyelf/_Main/Java_projects/Complex/src/test/java/com/lazyelf/storage/OutTest.txt";
        System.setOut(new PrintStream(name));
        bouquet.changeFlower(10);
        Scanner in = new Scanner(new FileInputStream(name));
        String s = in.nextLine();
        System.setOut(out);
        assertEquals("\t\tFlower 10 do not exists.", s);
    }

}