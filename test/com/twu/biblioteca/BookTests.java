package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

public class BookTests {

    private Book book;
    private Library library;

    @Before
    public void initialize() {
        library = new Library();
        TestHelper.givenLibraryHasOneBook(library);
        book = new Book(1,"Harry Potter","JK Rowling", 1997);
    }

    @Test
    public void setUnavailableBook() {
        book.setUnavailable();
        assertFalse(book.isAvailable());
    }

    @Test
    public void setAvailableBook() {
        book.setAvailable();
        assertTrue(book.isAvailable());
    }

    @Test
    public void createdAvailableBook() {
        assertTrue(book.isAvailable());
    }

    @Test
    public void successfullFindBookByID() {
        Book book = (Book) library.findItem(1);
        assertEquals(book.getTitle().compareTo("Harry Potter"),0);
    }

    @Test
    public void unsuccessfullFindBookByID() {
        Book book = (Book) library.findItem(22);
        assertEquals(null,book);
    }

}
