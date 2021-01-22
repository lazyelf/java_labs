package com.lazyelf.storage.bouquetsComponents;

import java.io.Serializable;
import java.util.Scanner;

public class Decoration implements Serializable {
    private final String name;
    private final double price;
    static transient Scanner in = null;

    public Decoration(Scanner in) {
        System.out.print("\t\tEnter name of decoration: ");
        if (Decoration.in == null)
            Decoration.in = in;
        name = in.nextLine();
        System.out.printf("\t\tEnter price of %s: ", name);
        price = in.nextDouble();
        if (in.hasNext())
            in.nextLine();
    }

    @Override
    public String toString() {
        return "Decoration " + name + " price - " + price;
    }

    public double getPrice() {
        return price;
    }
}
