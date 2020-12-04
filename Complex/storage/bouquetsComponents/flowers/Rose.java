package com.lazyelf.storage.bouquetsComponents.flowers;

import java.util.Scanner;

public class Rose extends Flower {

    public Rose() {
        super();
        name = "Rose";
        chooseButtonSize();
        chooseLength();
        chooseColor();
        setPrice();
        verdure = 8;
    }

    protected void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - wine\n"
                + "\t\t2 - blue\n"
                + "\t\t3 - yellow\n"
                + "\t\t4 - black\n"
                + "\t\t5 - pink\n"
                + "\t\t6 - white\n\t\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 2:
                color = "blue";
                break;
            case 3:
                color = "yellow";
                break;
            case 4:
                color = "black";
                break;
            case 5:
                color = "pink";
                break;
            case 6:
                color = "white";
                break;
            default:
                color = "wine";
        }
    }

    protected void chooseButtonSize() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter button size of %s: ", name);
            buttonSize = in.nextInt();
        } while (buttonSize < 7 || buttonSize > 25);
    }

    protected void chooseLength() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 30 || length > 120);
    }

    protected void setPrice() {
        price = (1 / (double) buttonSize * 15 + (double) length / 3);
    }
}
