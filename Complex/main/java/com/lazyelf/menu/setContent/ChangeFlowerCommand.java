package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

import java.util.Scanner;

public class ChangeFlowerCommand implements ICommand {
    Storage storage;

    public ChangeFlowerCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("\t\tEnter order of flower to change: ");
        storage.changeFlower(in.nextInt());

    }
}
