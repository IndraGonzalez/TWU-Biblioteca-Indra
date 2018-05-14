package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.*;

public class LibraryAppTest {

    Library library;

    @Test
    public void emptyLibraryListsNoBooks() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        givenLibraryIsEmpty();
        whenListBooks();
        thenListIsEmpty();

        thenShowsMessageLibraryIsEmpty(outputStream);
    }

    private void thenShowsMessageLibraryIsEmpty(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("The library is empty"));
    }

    @Test
    public void libraryWithOneBookList() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        givenLibraryHasOneBook();
        whenListBooks();
        thenListHasOneBook();

        thenListContainsBookHarryPotter(outputStream);
    }

    @Test
    public void libraryWithMoreThanOneBook() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        givenLibraryHasThreeBook();
        whenListBooks();
        thenListHasThreeBooks();

        thenListContainsBookHarryPotter(outputStream);
        thenListContainsBookRobinson(outputStream);
        thenListContainsBookFrankenstein(outputStream);
    }


    private void thenListContainsBookFrankenstein(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Frankenstein"));
    }

    private void thenListContainsBookRobinson(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Robinson Crusoe"));
    }

    private void thenListContainsBookHarryPotter(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Harry Potter"));
    }

    private void thenListHasThreeBooks() {
        assertEquals(library.getBooks().size(),3);
    }

    private void givenLibraryHasThreeBook() {
        givenLibraryIsEmpty();
        library.addBook(new Book("Harry Potter","JK Rowling", 1997));
        library.addBook(new Book("Robinson Crusoe", "Daniel Defoe", 1719));
        library.addBook(new Book("Frankenstein","Mary Shelley", 1797));
    }

    private void thenListHasOneBook() {
        assertEquals(library.getBooks().size(),1);
    }

    private void givenLibraryHasOneBook() {
        givenLibraryIsEmpty();
        library.addBook(new Book("Harry Potter","JK Rowling", 1997));
    }

    private void thenListIsEmpty() {
        assertEquals(library.getBooks().size(),0);
    }

    private void whenListBooks() {
        library.listBooks();
    }

    private void givenLibraryIsEmpty() {
        library = new Library();
    }

    private OutputStream prepareRedirectOutputForTests(){

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
        return outputStream;
    }
}