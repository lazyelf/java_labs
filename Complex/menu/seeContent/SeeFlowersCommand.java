package com.lazyelf.menu.seeContent;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.ICommand;

public class SeeFlowersCommand implements ICommand {
    Storage storage;

    public SeeFlowersCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        storage.showFlowers();
    }
}
