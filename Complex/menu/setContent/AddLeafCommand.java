package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class AddLeafCommand implements ICommand {
    Storage storage;

    public AddLeafCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.addLeaf();
    }
}
