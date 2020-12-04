package com.company.book;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int yearOfPublication;
    private int pageAmount;
    private int price;

    public Book(int id, String title,
                String author,
                String publishingHouse,
                int yearOfPublication,
                int pageAmount,
                int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfPublication = yearOfPublication;
        this.pageAmount = pageAmount;
        this.price = price;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublishingHouse() {
        return publishingHouse;
    }
    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public int getPageAmount() {
        return pageAmount;
    }
    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book { " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", publishingHouse = '" + publishingHouse + '\'' +
                ", yearOfPublication = " + yearOfPublication +
                ", pageAmount = " + pageAmount +
                ", price = " + price +
                " }";
    }
}
