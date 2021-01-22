package com.lazyelf;

import com.lazyelf.storage.Storage;
import com.lazyelf.menu.Switch;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Storage storage = new Storage(in);

        try {
            FileInputStream f = new FileInputStream(args[0]);
            ObjectInputStream o = new ObjectInputStream(f);
            logger.info("File was opened");

            storage = (Storage) o.readObject();
            logger.info("Storage info was been copied.");

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            logger.error("File not found.");
        } catch (IOException e) {
            logger.error("Error initializing stream.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("Class not found.");
        }

        Switch s = new Switch(storage);
        System.out.println("Viktoriia Mykhailova -> lazyelf");
        do {
            logger.info("Mein menu is called.");
            System.out.println("________Menu________");
        } while (s.chooseCommand());


        try {

            FileOutputStream f = new FileOutputStream(args[0]);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(storage);
            logger.info("Storage info was saved.");

            o.close();
            f.close();
            logger.info("File was closed");
            //throw new Exception();

        } catch (FileNotFoundException e) {
            logger.error("File not found.");

        } catch (IOException e) {
            logger.error("Error initializing stream.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Hello!");
        }
    }
}