package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class TestHelper {

    public static void givenLibraryHasOneBook(Library library) {
        library.addItem(new Book(1,"Harry Potter","JK Rowling", 1997));
    }
    public static void givenLibraryHasThreeBook(Library library) {
        library.addItem(new Book(1,"Harry Potter","JK Rowling", 1997));
        library.addItem(new Book(2,"Robinson Crusoe", "Daniel Defoe", 1719));
        library.addItem(new Book(3,"Frankenstein","Mary Shelley", 1797));
    }

    public static OutputStream prepareRedirectOutputForTests(){
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
        return outputStream;
    }

}
