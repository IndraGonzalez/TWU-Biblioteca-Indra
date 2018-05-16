package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Book extends CheckableItem {

    private String title;
    private String author;
    private int year;

    public Book(int id, String title, String author, int year) {
        super(id);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getPrint() {
        return (this.getId() + "\t\t" + title + "\t\t" + author + "\t\t" + year);
    }
}
