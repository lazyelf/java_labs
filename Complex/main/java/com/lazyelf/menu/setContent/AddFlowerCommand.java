package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class AddFlowerCommand implements ICommand {
    Storage storage;

    public AddFlowerCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.addFlower();
    }
}
