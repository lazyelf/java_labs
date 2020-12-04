package com.lazyelf.storage.bouquetsComponents.flowers;

import java.util.Scanner;

public class Peony extends Flower {

    public Peony() {
        super();
        name = "Peony";
        chooseButtonSize();
        chooseLength();
        chooseColor();
        setPrice();
        verdure = 7;
    }

    protected void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - pink\n"
                + "\t\t2 - red\n"
                + "\t\t3 - white\n"
                + "\t\t4 - violet\n\t\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 2:
                color = "red";
                break;
            case 3:
                color = "white";
                break;
            case 4:
                color = "violet";
                break;
            default:
                color = "pink";
        }
    }

    protected void chooseButtonSize() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter button size of %s: ", name);
            buttonSize = in.nextInt();
        } while (buttonSize < 15 || buttonSize > 25);
    }

    protected void chooseLength() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 30 || length > 70);
    }

    protected void setPrice() {
        price = (1 / (double) buttonSize * 10 + (double) length / 5) * 5;
    }
}
