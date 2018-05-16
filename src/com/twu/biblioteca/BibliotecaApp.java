package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        library.addItem(new Book(1,"Harry Potter", "JK Rowling", 1997));

        Navigator navigator = new Navigator(library);
        navigator.showWelcomeMessage();
        //navigator.showMenu();

        library.checkoutItem(22);

    }

}