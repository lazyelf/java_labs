package com.lazyelf.storage.bouquetsComponents.leaves;

import java.util.Scanner;

public class Lavender extends Leaf {

    public Lavender(Scanner in) {
        super(in);
        name = "Lavender";
        price = 8;
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 7 || length > 13);
        chooseColor();
    }

    public void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - violet\n"
                + "\t\t2 - blue\n\t\t");
        if (in.nextInt() == 2) {
            color = "blue";
        } else {
            color = "violet";
        }
    }
}
