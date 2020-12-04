package com.lazyelf;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.Switch;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();

        try {
            FileInputStream f = new FileInputStream(new File(args[0]));
            ObjectInputStream o = new ObjectInputStream(f);

            storage = (Storage) o.readObject();

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error initializing stream.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Switch s = new Switch(storage);
        System.out.println("Viktoriia Mykhailova -> lazyelf");
        do {
            System.out.println("________Menu________");
        } while (s.chooseCommand());


        try {
            FileOutputStream f = new FileOutputStream(new File(args[0]));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(storage);
            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}