package com.company;

import com.company.book.Book;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
1.  Створити проект, що складається з двох класів: основного (Main) та класу для представлення об’єкта відповідно
    специфікації, що  наведена у таблиці 1. Кожний клас повинен бути розміщений у  окремому пакеті. У створеному класі
    визначити приватні поля для  зберігання указаних даних, конструктори для створення об’єктів  та відкриті методи
    setValue(), getValue(), toString() для доступу до полів об’єкту.
2.  В основному класі програми визначити методи, що створюють масив обєктів. Задати критерії вибору даних та
    вивести ці дані на консоль. Для кожного критерію створити окремий метод.
3.  Виконати програму, та пересвідчитись, що дані зберігаються та коректно виводяться на екран відповідно до
    вказаних критеріїв.

5   Book: id, Назва, Автор, Видавництво, Рік видання, Кількість сторінок, Ціна.
    Скласти масив обєктів. Вивести:
    a) список книг заданого автора;
    b) список книг, що видані заданим видавництвом;
    c) список книг, що випущені після заданого року.
 */

public class Main {

    public static int createBooksArr(ArrayList<Book> arr, String path) {

        try (FileInputStream file = new FileInputStream(path)) {
            System.out.printf("File size: %d bytes \n", file.available());

            Scanner in = new Scanner(file);
            while (in.hasNextInt()) {
                Book addBook = new Book();
                addBook.setId(in.nextInt());
                in.nextLine();
                addBook.setTitle(in.nextLine());
                addBook.setAuthor(in.nextLine());
                addBook.setPublishingHouse(in.nextLine());
                addBook.setYearOfPublication(in.nextInt());
                in.nextLine();
                addBook.setPageAmount(in.nextInt());
                in.nextLine();
                addBook.setPrice(in.nextInt());
                in.nextLine();

                arr.add(addBook);
            }
            in.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return arr.size();
    }

    static void printBooksArr(ArrayList<Book> arr, int amount) {
        System.out.println("Elements of array: ");
        for (int i = 0; i < amount; ++i) {
            System.out.println(arr.get(i).toString());
        }
    }

    public static void printAuthorsBooks(String author, ArrayList<Book> arr, int amount) {
        System.out.println("Books by " + author);
        boolean flag = true;
        for (int i = 0; i < amount; ++i) {
            if (arr.get(i).getAuthor().equals(author)) {
                System.out.println(arr.get(i).toString());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("none were found");
        }
    }

    public static void printPublishHousesBooks(String publishHouse, ArrayList<Book> arr, int amount) {
        System.out.println("Books by " + publishHouse);
        boolean flag = true;
        for (int i = 0; i < amount; ++i) {
            if (arr.get(i).getPublishingHouse().equals(publishHouse)) {
                System.out.println(arr.get(i).toString());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("none were found");
        }
    }

    public static void printNewerBooks(int year, ArrayList<Book> arr, int amount) {
        System.out.println("Books newer than " + year);
        boolean flag = true;
        for (int i = 0; i < amount; ++i) {
            if (arr.get(i).getYearOfPublication() > year) {
                System.out.println(arr.get(i).toString());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("none were found");
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> arr = new ArrayList<>();
        int amount = createBooksArr(arr, args[0]);
        printBooksArr(arr, amount);

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter author: ");
        String temp = in.nextLine();
        printAuthorsBooks(temp, arr, amount);

        System.out.print("Please enter publish house: ");
        temp = in.nextLine();
        printPublishHousesBooks(temp, arr, amount);

        System.out.print("Please enter year: ");
        int year = in.nextInt();
        printNewerBooks(year, arr, amount);

        in.close();
        arr.clear();
    }
}

