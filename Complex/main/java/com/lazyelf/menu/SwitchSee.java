package com.lazyelf.menu;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.seeContent.*;

import java.util.Scanner;

public class SwitchSee {
    private final ICommand seeBouquetsCommand;
    private final ICommand seeDecorationsCommand;
    private final ICommand seeFlowersCommand;
    private final ICommand seeLeavesCommand;
    private final ICommand sortBouquetsCommand;
    private final ICommand sortFlowersCommand;

    public SwitchSee(Storage storage) {
        this.seeBouquetsCommand = new SeeBouquetsCommand(storage);
        this.seeDecorationsCommand = new SeeDecorationsCommand(storage);
        this.seeFlowersCommand = new SeeFlowersCommand(storage);
        this.seeLeavesCommand = new SeeLeavesCommand(storage);
        this.sortBouquetsCommand = new SortBouquetsCommand(storage);
        this.sortFlowersCommand = new SortFlowersCommand(storage);
    }

    public boolean chooseCommand() {
        System.out.print("\t1 - see list of bouquets\n"
                + "\t2 - see list of decorations\n"
                + "\t3 - see list of flowers\n"
                + "\t4 - see list of leaves\n"
                + "\t5 - sort list of bouquets\n"
                + "\t6 - sort list of flowers\n"
                + "\t7 - return\n\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                seeBouquetsCommand();
                break;
            case 2:
                seeDecorationsCommand();
                break;
            case 3:
                seeFlowersCommand();
                break;
            case 4:
                seeLeavesCommand();
                break;
            case 5:
                sortBouquetsCommand();
                seeBouquetsCommand();
                break;
            case 6:
                sortFlowersCommand();
                seeFlowersCommand();
                break;
            default:
                return false;
        }
        return true;
    }

    private void seeBouquetsCommand() {
        seeBouquetsCommand.execute();
    }

    private void seeDecorationsCommand() {
        seeDecorationsCommand.execute();
    }

    private void seeFlowersCommand() {
        seeFlowersCommand.execute();
    }

    private void seeLeavesCommand() {
        seeLeavesCommand.execute();
    }

    private void sortBouquetsCommand() {
        sortBouquetsCommand.execute();
    }

    private void sortFlowersCommand() {
        sortFlowersCommand.execute();
    }

}
