package com.lazyelf.menu.seeContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class SeeDecorationsCommand implements ICommand {
    Storage storage;

    public SeeDecorationsCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.showDecorations();
    }
}
