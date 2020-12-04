package com.lazyelf.menu.setContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class CreateBouquetCommand implements ICommand {
    Storage storage;

    public CreateBouquetCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.createBouquet();
    }
}
