package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
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
        List<String> booksToShow = getBookList();
        showBookList(booksToShow);
    }

    public void showBookList(List<String> booksToShow) {
        Iterator<String> booksIterator = booksToShow.iterator();
        while(booksIterator.hasNext()){
            System.out.println(booksIterator.next());
        }
    }

    public List<String> getBookList() {
        List<String> booksToShow = new ArrayList<String>();

        Iterator<Book> booksIterator = books.iterator();
        while(booksIterator.hasNext()){
            Book book = booksIterator.next();
            if(book.isAvailable()) booksToShow.add(book.getId() + "\t\t" + book.getTitle() + "\t\t" + book.getAuthor() + "\t\t" + book.getYear());
        }
        return booksToShow;
    }

    public void addBook(Book book){
        this.books.add(book);
    }


    public void checkoutBook(int id) {
        if(books.size() == 0) {
            System.out.println("The book is not available: The library is empty");
            return;
        }
        Book book = findBook(id);
        if((book != null) && (book.isAvailable())) {
            book.setUnavailable();
            System.out.println("Thank you! Enjoy your book");
        }
        else System.out.println("The book is not available");
    }

    public void returnBook(int id) {
        Book book = findBook(id);
        if((book != null) && (!book.isAvailable())) {
            book.setAvailable();
            System.out.println("Thank you for returning your book");
        }
        else System.out.println("That is not a valid book to return");
    }

    public Book findBook(int id) {
        int index = 0;
        while(index < books.size()){
            if(books.get(index).getId() != id) index++;
            else return books.get(index);
        }
        return null;
    }
}
