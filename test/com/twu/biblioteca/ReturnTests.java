package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import static org.testng.AssertJUnit.assertEquals;

public class ReturnTests {

    private Library library;

    @Before
    public void initialize() {
        library = new Library();
    }

    @Test
    public void successfulReturn() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        library.getItems().get(0).setUnavailable();
        whenReturnBook(1);
        thenShowMessageSuccessfulReturn(outputStream);
    }

    private void thenShowMessageSuccessfulReturn(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("Thank you for returning your book\n"),0);
    }

    @Test
    public void unsuccessfulReturnBookDoesNotExist() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        whenReturnBook(22);
        thenShowMessageUnsuccessfulReturn(outputStream);
    }

    @Test
    public void unsuccesfulReturnBookCanNotBeReturn() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        whenReturnBook(1);
        thenShowMessageUnsuccessfulReturn(outputStream);
    }

    private void thenShowMessageUnsuccessfulReturn(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("That is not a valid book to return\n"),0);
    }

    private void whenReturnBook(int id) {
        library.returnBook(id);
    }

    private void whenCheckoutBook(int id) {
        library.checkoutItem(id);
    }

}
