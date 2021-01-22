package com.lazyelf.menu.seeContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class SeeBouquetsCommand implements ICommand {
    Storage storage;

    public SeeBouquetsCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.showBouquets();
    }
}
