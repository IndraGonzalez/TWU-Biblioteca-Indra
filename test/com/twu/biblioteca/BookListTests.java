package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.List;

import static com.twu.biblioteca.TestHelper.prepareRedirectOutputForTests;
import static org.testng.Assert.*;

public class BookListTests {

    private Library library;

    @Before
    public void initialize() {
        library = new Library();
    }

    @Test
    public void emptyLibraryListsNoBooks() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        whenListBooks();
        thenListIsEmpty();
        thenShowsMessageLibraryIsEmpty(outputStream);
    }

    public void thenShowsMessageLibraryIsEmpty(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("The library is empty"));
    }

    @Test
    public void libraryWithOneBookList() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        TestHelper.givenLibraryHasOneBook(library);
        whenListBooks();
        thenListHasOneBook();

        thenListContainsBookOne(outputStream);
    }

    @Test
    public void libraryWithMoreThanOneBook() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        TestHelper.givenLibraryHasThreeBook(library);
        whenListBooks();
        thenListHasThreeBooks();

        thenListContainsBookOne(outputStream);
        thenListContainsBookTwo(outputStream);
        thenListContainsBookThree(outputStream);
    }

    @Test
    public void listWithAllBooksAvailable() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        TestHelper.givenLibraryHasThreeBook(library);
        List<String> booksToShow = library.getAvailableBooksList();
        assertEquals(booksToShow.size(),3);
    }

    @Test
    public void listOnlyShowsBooksAvailableAfterCheckout() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        TestHelper.givenLibraryHasThreeBook(library);
        library.checkoutItem(1);
        List<String> booksToShow = library.getAvailableBooksList();
        assertEquals(booksToShow.size(),2);
    }

    private void thenListContainsBookThree(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Frankenstein"));
    }

    private void thenListContainsBookTwo(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Robinson Crusoe"));
    }

    private void thenListContainsBookOne(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Harry Potter"));
    }

    private void thenListHasThreeBooks() {
        assertEquals(library.getItems('b').size(),3);
    }

    private void thenListHasOneBook() {
        assertEquals(library.getItems('b').size(),1);
    }

    private void thenListIsEmpty() {
        assertEquals(library.getItems('b').size(),0);
    }

    private void whenListBooks() {
        library.listItems('b');
    }


}