package com.lazyelf.menu.setContent;

import com.lazyelf.menu.ICommand;
import com.lazyelf.storage.Storage;

import java.util.Scanner;

public class RemoveBouquetCommand implements ICommand {
    Storage storage;

    public RemoveBouquetCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("\t\tEnter order of bouquet to change: ");
        storage.removeBouquet(in.nextInt());
    }
}