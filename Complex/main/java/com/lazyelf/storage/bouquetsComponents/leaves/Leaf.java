package com.lazyelf.storage.bouquetsComponents.leaves;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Leaf implements Serializable  {
    protected String name;
    protected int length;
    protected String color;
    protected double price;
    static transient Scanner in = null;

    public Leaf(Scanner in)
    {
            Leaf.in = in;
    }

    public abstract void chooseColor();

    @Override
    public String toString() {
        return "Leaf " +
                color + ' ' + name +
                " with length " + length +
                " price - " + price;
    }

    public double getPrice() {
        return price;
    }
}
