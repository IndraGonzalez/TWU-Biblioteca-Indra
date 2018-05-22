package com.twu.biblioteca;

public class ItemsDB {

    public static void setItemsDB() {
        LibraryManager.addItem(new Book(1,"Harry Potter", "JK Rowling", 1997));
        LibraryManager.addItem(new Book(2,"Robinson Crusoe", "Daniel Defoe", 1719));
        LibraryManager.addItem(new Book(3,"Frankenstein","Mary Shelley", 1797));
        LibraryManager.addItem(new Movie(4,"Kill Bill","Tarantino", 4));
        LibraryManager.addItem(new Movie(5,"La la land","Damien Chazelle"));
    }
}
