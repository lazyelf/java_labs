package com.lazyelf.menu.seeContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class SeeLeavesCommand implements ICommand {
    Storage storage;

    public SeeLeavesCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.showLeaves();
    }
}
