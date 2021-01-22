package com.lazyelf.menu.seeContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

import java.util.Scanner;

public class SortFlowersCommand implements ICommand {
    Storage storage;

    public SortFlowersCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        System.out.print("\t\t1 - sort list by length\n"
                + "\t\t2 - sort list by button size\n\t\t");

        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                storage.sortFlowersByLength();
                break;
            case 2:
                storage.sortFlowersByButtonSize();
                break;
        }

    }
}
