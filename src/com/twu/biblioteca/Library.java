package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks(){
        if(books.size() == 0) {
            System.out.println("The library is empty");
            return;
        }
        System.out.println(" ---- BOOKS ----");
        Iterator<Book> booksIterator = books.iterator();
        while(booksIterator.hasNext()){
            Book book = booksIterator.next();
            System.out.println(book.getTitle() + "\t\t" + book.getAuthor() + "\t\t" + book.getYear());
        }
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
