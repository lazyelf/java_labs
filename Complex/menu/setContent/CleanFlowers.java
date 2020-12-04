package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class CleanFlowers implements ICommand {
    Storage storage;

    public CleanFlowers(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.cleanFlowers();
    }
}
