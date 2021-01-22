package com.lazyelf.storage.bouquetsComponents.flowers;

import java.util.Scanner;

public class Orchid extends Flower {

    public Orchid(Scanner in) {
        super(in);
        name = "Orchid";
        chooseButtonSize();
        chooseLength();
        chooseColor();
        setPrice();
        verdure = 12;
    }

    protected void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - wine\n"
                + "\t\t2 - blue\n"
                + "\t\t3 - yellow\n"
                + "\t\t4 - lime\n"
                + "\t\t5 - pink\n"
                + "\t\t6 - white\n"
                + "\t\t7 - black\n"
                + "\t\t8 - violet\n\t\t");
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
            case 7:
                color = "black";
                break;
            case 8:
                color = "violet";
                break;
            default:
                color = "wine";
        }
    }

    protected void chooseButtonSize() {
        do {
            System.out.printf("\t\tEnter button size of %s: ", name);
            buttonSize = in.nextInt();
        } while (buttonSize < 5 || buttonSize > 10);
    }

    protected void chooseLength() {
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 10 || length > 50);
    }

    protected void setPrice() {
        price = (buttonSize * 2 + (double) length / 3) * 2;
    }
}
