package com.lazyelf.storage.bouquetsComponents.flowers;

import java.util.Scanner;

public class Carnation extends Flower {

    public Carnation() {
        super();
        name = "Carnation";
        chooseButtonSize();
        chooseLength();
        chooseColor();
        setPrice();
        verdure = 10;
    }

    protected void chooseColor() {
        System.out.printf("\t\tPlease choose color of %s:\n", name);
        System.out.print("\t\t1 - red\n"
                + "\t\t2 - pink\n"
                + "\t\t3 - white\n"
                + "\t\t4 - violet\n\t\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 2:
                color = "pink";
                break;
            case 3:
                color = "white";
                break;
            case 4:
                color = "violet";
                break;
            default:
                color = "red";
        }
    }

    protected void chooseButtonSize() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter button size of %s: ", name);
            buttonSize = in.nextInt();
        } while (buttonSize < 6 || buttonSize > 10);
    }

    protected void chooseLength() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("\t\tEnter length of %s: ", name);
            length = in.nextInt();
        } while (length < 10 || length > 70);
    }

    protected void setPrice() {
        price = buttonSize + (double) length / 5;
    }
}
