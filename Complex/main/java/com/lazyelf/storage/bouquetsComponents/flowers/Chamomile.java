package com.lazyelf.storage.bouquetsComponents.flowers;

import java.util.Scanner;

public class Chamomile extends Flower {

    public Chamomile(Scanner in) {
        super(in);
        name = "Chamomile";
        chooseButtonSize();
        chooseLength();
        chooseColor();
        setPrice();
        verdure = 18;
    }

    protected void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - white\n"
                + "\t\t2 - blue\n"
                + "\t\t3 - yellow\n"
                + "\t\t4 - lime\n\t\t");
        switch (in.nextInt()) {
            case 2:
                color = "blue";
                break;
            case 3:
                color = "yellow";
                break;
            case 4:
                color = "lime";
                break;
            default:
                color = "while";
        }
    }

    protected void chooseButtonSize() {
        do {
            System.out.printf("\t\tEnter button size of %s: ", name);
            buttonSize = in.nextInt();
        } while (buttonSize < 5 || buttonSize > 15);

    }

    protected void chooseLength() {
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 10 || length > 70);
    }

    protected void setPrice() {
        price = (buttonSize + (double) length / 5);
    }
}
