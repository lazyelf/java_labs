package com.lazyelf.storage;

import com.lazyelf.storage.bouquetsComponents.Decoration;
import com.lazyelf.storage.bouquetsComponents.flowers.Flower;
import com.lazyelf.storage.bouquetsComponents.leaves.Leaf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Bouquet implements Serializable {
    private final ArrayList<Flower> flowers = new ArrayList<>();
    private final ArrayList<Leaf> leaves = new ArrayList<>();
    private final ArrayList<Decoration> decorations = new ArrayList<>();
    private double price;
    private final String name;
    static transient Scanner in = null;

    public static Comparator<Flower> FlowerLength = Comparator.comparingInt(Flower::getLength);
    public static Comparator<Flower> FlowerButtonSize = Comparator.comparingInt(Flower::getButtonSize);

    public Bouquet(String name, Scanner in) {
        this.name = name;
        if (Bouquet.in == null)
            Bouquet.in = in;
    }

    public void addFlower(Flower f) {
        flowers.add(f);
    }

    public void addLeaf(Leaf l) {
        leaves.add(l);
    }

    public void addDecoration(Decoration d) {
        decorations.add(d);
    }

    public Flower removeFlower(int order) {
        Flower f = flowers.get(order - 1);
        flowers.remove(order - 1);
        return f;
    }

    public Leaf removeLeaf(int order) {
        Leaf l = leaves.get(order - 1);
        leaves.remove(order - 1);
        return l;
    }

    public Decoration removeDecoration(int order) {
        Decoration d = decorations.get(order - 1);
        decorations.remove(order - 1);
        return d;
    }

    public void sortFlowersByLength() {
        System.out.println("\t\t\tSorting list of flowers...");
        flowers.sort(FlowerLength);
    }

    public void sortFlowersByButtonSize() {
        System.out.println("\t\t\tSorting list of flowers...");
        flowers.sort(FlowerButtonSize);
    }

    public void findFlowerByLength() {
        System.out.print("\t\t\tEnter range of flower length: ");
        int begin = in.nextInt(), end = in.nextInt();
        for (Flower f : flowers) {
            if (f.getLength() >= begin && f.getLength() <= end) {
                System.out.println("\t\t\t" + f.toString());
            }
        }
    }

    public void findFlowerByButtonSize() {
        System.out.print("\t\t\tEnter range of flower button size: ");
        int begin = in.nextInt(), end = in.nextInt();
        for (Flower f : flowers) {
            if (f.getButtonSize() >= begin && f.getButtonSize() <= end) {
                System.out.println("\t\t\t" + f.toString());
            }
        }
    }

    public void changeFlower(int order) {
        if (order > flowers.size() || order < 0) {
            System.out.printf("\t\tFlower %d do not exists.\n", order);
            return;
        }
        System.out.printf("\t\tChanging %d flower:\n", order);
        System.out.println("\t\t" + flowers.get(order - 1).toString());
        flowers.get(order - 1).changeFlower();
    }

    public double getValue() {
        price = 0;

        for (Flower f : flowers) {
            price += f.getPrice();
        }
        for (Leaf l : leaves) {
            price += l.getPrice();
        }
        for (Decoration d : decorations) {
            price += d.getPrice();
        }
        return Math.ceil(price * 100) / 100;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Bouquet " + name + " with price " + price + '\n');
        int i = 1;
        if (flowers.size() != 0) {
            result.append("\t\t\t\tFlowers:\n");
            for (Flower f : flowers) {
                result.append("\t\t\t\t\t").append(i).append(". ").append(f.toString()).append('\n');
                ++i;
            }
        }

        if (leaves.size() != 0) {
            i = 1;
            result.append("\t\t\t\tLeaves:\n");
            for (Leaf l : leaves) {
                result.append("\t\t\t\t\t").append(i).append(". ").append(l.toString()).append('\n');
                ++i;
            }
        }

        if (decorations.size() != 0) {
            i = 1;
            result.append("\t\t\t\tDecorations:\n");
            for (Decoration d : decorations) {
                result.append("\t\t\t\t\t").append(i).append(". ").append(d.toString()).append('\n');
                ++i;
            }
        }

        return result.toString();
    }

    public void setIn(Scanner in) {
        Bouquet.in = in;
    }

    public boolean isNotEmpty() {
        return flowers.size() != 0 || leaves.size() != 0 || decorations.size() != 0;
    }
}
