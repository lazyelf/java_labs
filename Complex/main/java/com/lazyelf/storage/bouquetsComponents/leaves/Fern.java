package com.lazyelf.storage.bouquetsComponents.leaves;

import java.util.Scanner;

public class Fern extends Leaf {

    public Fern(Scanner in) {
        super(in);
        name = "Fern";
        price = 10;
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 15 || length > 30);
        chooseColor();
    }

    public void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - green\n"
                + "\t\t2 - black\n\t\t");
        if (in.nextInt() == 2) {
            color = "black";
        } else {
            color = "green";
        }
    }
}