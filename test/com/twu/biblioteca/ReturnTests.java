package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import static org.testng.AssertJUnit.assertEquals;

public class ReturnTests {

    private LibraryManager library;
    private UserManager userManager;


    @Before
    public void initialize() {
        library = new LibraryManager();
        TestHelper.giveOneCustomer(library);
    }

    @Test
    public void successfulReturn() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        library.getItems('b').get(0).setUnavailable();
        whenReturnBook(1);
        thenShowMessageSuccessfulReturn(outputStream);
    }

    private void thenShowMessageSuccessfulReturn(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("Thank you for returning your item\n"),0);
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
        assertEquals(outputStream.toString().compareTo("That is not a valid item to return\n"),0);
    }

    private void whenReturnBook(int id) {
        library.returnItem(id);
    }

    private void whenCheckoutBook(int id) {
        library.checkoutItem(id,userManager.getCurrentUser());
    }

}
