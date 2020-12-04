package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class AddDecorationCommand implements ICommand {
    Storage storage;

    public AddDecorationCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.addDecoration();
    }
}
