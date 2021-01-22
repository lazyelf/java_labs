package com.lazyelf.storage.bouquetsComponents.flowers;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {
    @Test
    public void checkPriceCarnation() {
        String s = "10 70 1\n";
        Scanner in = new Scanner(s);
        Carnation f1 = new Carnation(in);
        assertEquals(24, f1.getPrice());
    }

    @Test
    public void checkPriceChamomile() {
        String s = "15 70 1\n";
        Scanner in = new Scanner(s);
        Chamomile f2 = new Chamomile(in);
        assertEquals(29, f2.getPrice());
    }

    @Test
    public void checkPriceChrysanthemum() {
        String s = "20 70 1\n";
        Scanner in = new Scanner(s);
        Chrysanthemum f3 = new Chrysanthemum(in);
        assertEquals(136, f3.getPrice());
    }

    @Test
    public void checkPriceOrchid() {
        String s = "10 50 1\n";
        Scanner in = new Scanner(s);
        Orchid f4 = new Orchid(in);
        assertEquals(73.34, f4.getPrice());
    }

    @Test
    public void checkPricePeony() {
        String s = "25 70 1\n";
        Scanner in = new Scanner(s);
        Peony f5 = new Peony(in);
        assertEquals(72, f5.getPrice());
    }

    @Test
    public void checkPriceRose() {
        String s = "25 120 1\n";
        Scanner in = new Scanner(s);
        Rose f6 = new Rose(in);
        assertEquals(40.6, f6.getPrice());
    }

    @Test
    public void checkPriceTulip() {
        String s = "10 40 1\n";
        Scanner in = new Scanner(s);
        Tulip f7 = new Tulip(in);
        assertEquals(72.15, f7.getPrice());
    }

    @Test
    public void checkVerdureCarnation() {
        String s = "10 70 1\n";
        Scanner in = new Scanner(s);
        Carnation f1 = new Carnation(in);
        assertFalse(f1.checkVerdure(LocalDate.now()));
    }

    @Test
    public void checkVerdureChamomile() {
        String s = "15 70 1\n";
        Scanner in = new Scanner(s);
        Chamomile f2 = new Chamomile(in);
        assertFalse(f2.checkVerdure(LocalDate.now().plusDays(7)));
    }

    @Test
    public void checkVerdureChrysanthemum() {
        String s = "20 70 1\n";
        Scanner in = new Scanner(s);
        Chrysanthemum f3 = new Chrysanthemum(in);
        assertTrue(f3.checkVerdure(LocalDate.now().plusDays(20)));
    }

    @Test
    public void checkMultipleObjectInput() {
        String s = "10 50 1 25 70 1\n";
        Scanner in = new Scanner(s);
        Flower f4 = new Orchid(in);
        Flower f5 = new Peony(in);
        assertNotEquals(f4, f5);
    }

    @Test
    public void checkChangeFlower() {
        String s = "25 120 1 20\n";
        Scanner in = new Scanner(s);
        Flower f4 = new Rose(in);
        f4.changeFlower();
        assertEquals(40.6, f4.getPrice());
    }

}