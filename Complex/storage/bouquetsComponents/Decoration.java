package com.lazyelf.storage.bouquetsComponents;

import java.io.Serializable;
import java.util.Scanner;

public class Decoration implements Serializable {
    private final String name;
    private final double price;

    public Decoration() {
        System.out.print("\t\tEnter name of decoration: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        System.out.printf("\t\tEnter price of %s: ", name);
        price = in.nextDouble();
    }

    @Override
    public String toString() {
        return "Decoration " + name + " price - " + price;
    }

    public double getPrice() {
        return price;
    }
}
