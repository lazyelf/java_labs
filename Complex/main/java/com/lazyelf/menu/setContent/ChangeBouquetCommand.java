package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

import java.util.Scanner;

public class ChangeBouquetCommand implements ICommand {
    Storage storage;

    public ChangeBouquetCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        System.out.print("\t\t\tEnter order of bouquet that you want to change: ");
        Scanner in = new Scanner(System.in);
        storage.changeBouquet(in.nextInt());
    }
}
