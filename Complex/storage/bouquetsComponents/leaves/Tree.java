package com.lazyelf.storage.bouquetsComponents.leaves;

import java.util.Scanner;

public class Tree extends Leaf {

    public Tree() {
        name = "Tree";
        price = 4;
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length <= 10 || length >= 30);
        chooseColor();
    }

    public void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - green\n"
                + "\t\t2 - yellow\n"
                + "\t\t3 - brown\n"
                + "\t\t4 - red\n\t\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 2:
                color = "yellow";
                break;
            case 3:
                color = "brown";
                break;
            case 4:
                color = "red";
                break;
            default:
                color = "green";
        }
    }
}