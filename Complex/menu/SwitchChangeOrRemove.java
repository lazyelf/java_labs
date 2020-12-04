package com.lazyelf.menu;

import com.lazyelf.menu.setContent.RemoveBouquetCommand;
import com.lazyelf.menu.setContent.RemoveFlowerCommand;
import com.lazyelf.storage.Storage;
import com.lazyelf.menu.seeContent.SeeBouquetsCommand;
import com.lazyelf.menu.seeContent.SeeFlowersCommand;
import com.lazyelf.menu.setContent.ChangeBouquetCommand;
import com.lazyelf.menu.setContent.ChangeFlowerCommand;

import java.util.Scanner;

public class SwitchChangeOrRemove {
    private final ICommand changeBouquetCommand;
    private final ICommand changeFlowerCommand;
    private final ICommand seeBouquetsCommand;
    private final ICommand seeFlowersCommand;
    private final ICommand removeFlowerCommand;
    private final ICommand removeBouquetCommand;

    public SwitchChangeOrRemove(Storage storage) {

        this.changeBouquetCommand = new ChangeBouquetCommand(storage);
        this.changeFlowerCommand = new ChangeFlowerCommand(storage);
        this.seeBouquetsCommand = new SeeBouquetsCommand(storage);
        this.seeFlowersCommand = new SeeFlowersCommand(storage);
        this.removeFlowerCommand = new RemoveFlowerCommand(storage);
        this.removeBouquetCommand = new RemoveBouquetCommand(storage);
    }

    public boolean chooseCommand() {
        System.out.print("\t1 - change bouquet\n"
                + "\t2 - change flower\n"
                + "\t3 - remove bouquet\n"
                + "\t4 - remove flower\n"
                + "\t5 - return\n\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                seeBouquetsCommand();
                changeBouquetCommand();
                break;
            case 2:
                seeFlowersCommand();
                changeFlowerCommand();
                break;
            case 3:
                seeBouquetsCommand();
                removeBouquetCommand();
                break;
            case 4:
                seeFlowersCommand();
                removeFlowerCommand();
                break;
            default:
                return false;
        }
        return true;
    }

    private void removeFlowerCommand() {
        removeFlowerCommand.execute();
    }

    private void removeBouquetCommand() {
        removeBouquetCommand.execute();
    }

    private void changeBouquetCommand() {
        changeBouquetCommand.execute();
    }

    private void changeFlowerCommand() {
        changeFlowerCommand.execute();
    }

    private void seeBouquetsCommand() {
        seeBouquetsCommand.execute();
    }

    private void seeFlowersCommand() {
        seeFlowersCommand.execute();
    }
}
