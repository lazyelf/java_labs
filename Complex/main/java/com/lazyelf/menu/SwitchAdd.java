package com.lazyelf.menu;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.setContent.AddDecorationCommand;
import com.lazyelf.menu.setContent.AddFlowerCommand;
import com.lazyelf.menu.setContent.AddLeafCommand;
import com.lazyelf.menu.setContent.CreateBouquetCommand;

import java.util.Scanner;

public class SwitchAdd {
    private final ICommand addDecorationCommand;
    private final ICommand addFlowerCommand;
    private final ICommand addLeafCommand;
    private final ICommand createBouquetCommand;

    public SwitchAdd(Storage storage) {
        this.addDecorationCommand = new AddDecorationCommand(storage);
        this.addFlowerCommand = new AddFlowerCommand(storage);
        this.addLeafCommand = new AddLeafCommand(storage);
        this.createBouquetCommand = new CreateBouquetCommand(storage);
    }

    public boolean chooseCommand() {
        System.out.print("\t1 - add decoration\n"
                + "\t2 - add flower\n"
                + "\t3 - add leaf\n"
                + "\t4 - add bouquet\n"
                + "\t5 - return\n\t");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                addDecorationCommand();
                break;
            case 2:
                addFlowerCommand();
                break;
            case 3:
                addLeafCommand();
                break;
            case 4:
                createBouquetCommand();
                break;
            default:
                return false;
        }
        return true;
    }

    private void addDecorationCommand() {
        addDecorationCommand.execute();
    }

    private void addFlowerCommand() {
        addFlowerCommand.execute();
    }

    private void addLeafCommand() {
        addLeafCommand.execute();
    }

    private void createBouquetCommand() {
        createBouquetCommand.execute();
    }

}
