package com.lazyelf.storage.bouquetsComponents.leaves;

import java.util.Scanner;

public class Palm extends Leaf {

    public Palm(Scanner in) {
        super(in);
        name = "Palm";
        price = 12;
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 20 || length > 30);
        chooseColor();
    }

    public void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - green\n"
                + "\t\t2 - blue\n\t\t");
        if (in.nextInt() == 2) {
            color = "blue";
        } else {
            color = "green";
        }
    }
}
