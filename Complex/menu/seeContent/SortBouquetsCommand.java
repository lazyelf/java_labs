package com.lazyelf.menu.seeContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class SortBouquetsCommand implements ICommand {
    Storage storage;

    public SortBouquetsCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.sortBouquets();
    }
}
