package com.lazyelf.storage.bouquetsComponents.flowers;

import java.util.Scanner;

public class Tulip extends Flower {

    public Tulip() {
        super();
        name = "Tulip";
        chooseButtonSize();
        chooseLength();
        chooseColor();
        setPrice();
        verdure = 9;
    }

    protected void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - wine\n"
                + "\t\t2 - blue\n"
                + "\t\t3 - yellow\n"
                + "\t\t4 - lime\n"
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
                color = "lime";
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
        } while (buttonSize < 5 || buttonSize > 10);
    }

    protected void chooseLength() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 20 || length > 40);
    }

    protected void setPrice() {
        price = (1 / (double) buttonSize * 15 + (double) length / 7) * 2;
    }
}

