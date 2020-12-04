package com.lazyelf.menu;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.setContent.CleanFlowers;

import java.util.Scanner;

public class Switch {
    private final SwitchSee see;
    private final SwitchAdd add;
    private final SwitchChangeOrRemove change;
    private final ICommand cleanFlowers;

    public Switch(Storage storage) {
        cleanFlowers = new CleanFlowers(storage);
        see = new SwitchSee(storage);
        add = new SwitchAdd(storage);
        change = new SwitchChangeOrRemove(storage);
    }

    public boolean chooseCommand() {
        System.out.print("1 - clean flowers\n"
                + "2 - see subject\n"
                + "3 - add subject\n"
                + "4 - change subject\n"
                + "5 - exit\n");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                cleanFlowers();
                break;
            case 2:
                see();
                break;
            case 3:
                add();
                break;
            case 4:
                change();
                break;
            case 5:

                return false;
            default:
                System.out.println("Such command do not exist.");
        }
        return true;
    }

    private void cleanFlowers() {
        cleanFlowers.execute();
    }

    private void see() {
        do {
            System.out.println("\t____See subject_____");
        } while (see.chooseCommand());
    }

    private void add() {
        do {
            System.out.println("\t____Add subject_____");
        } while (add.chooseCommand());
    }

    private void change() {
        do {
            System.out.println("\t___Change subject___");
        } while (change.chooseCommand());
    }
}
