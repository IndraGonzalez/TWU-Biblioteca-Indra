package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        library.addItem(new Book(1,"Harry Potter", "JK Rowling", 1997));
        library.addItem(new Book(2,"Robinson Crusoe", "Daniel Defoe", 1719));
        library.addItem(new Book(3,"Frankenstein","Mary Shelley", 1797));
        library.addItem(new Movie(4,"Kill Bill","Tarantino", 4));
        library.addItem(new Movie(5,"La la land","Damien Chazelle"));

        UserManager userManager = new UserManager();
        userManager.addUser(new User("111-1111", "password",false,"Hermione","hermione@gmail.com","Hogwarts, Griffindor, girls room",666222666));
        userManager.addUser(new User("222-2222", "password",true,"Ron","ron@gmail.com","Hogwarts, Griffindor, boys room",666333666));

        Navigator navigator = new Navigator(library,userManager);
        navigator.showWelcomeMessage();
        navigator.loginMenu();

        //library.checkoutItem(22);

    }

}