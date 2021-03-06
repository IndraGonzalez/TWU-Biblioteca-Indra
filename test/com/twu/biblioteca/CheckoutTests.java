package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import static org.testng.AssertJUnit.assertEquals;

public class CheckoutTests {

    private LibraryManager library;
    private UserManager userManager;


    @Before
    public void initialize() {
        library = new LibraryManager();
        userManager = TestHelper.giveOneCustomer(library);
    }

    @Test
    public void unsuccessfulCheckoutLibraryIsEmpty() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        whenCheckoutBook(1);
        thenShowMessageUnsuccessfulCheckoutLibraryEmpty(outputStream);
    }

    private void thenShowMessageUnsuccessfulCheckoutLibraryEmpty(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("The item is not available: The library is empty\n"),0);
    }

    private void thenShowMessageUnsuccessfulCheckout(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("The item is not available\n"),0);
    }

    private void whenCheckoutBook(int id) {
        library.checkoutItem(id,userManager.getCurrentUser());
    }

    @Test
    public void successfulCheckout() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        whenCheckoutBook(1);
        thenShowMessageSuccessfulCheckout(outputStream);

    }

    private void thenShowMessageSuccessfulCheckout(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("Thank you! Enjoy your item\n"),0);
    }

    @Test
    public void unsuccessfulCheckoutBookDoesNotExist() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        whenCheckoutBook(22);
        thenShowMessageUnsuccessfulCheckout(outputStream);
    }

    @Test
    public void unsuccesfulChechoutBookCanNotBeCheckout() {
        OutputStream outputStream = TestHelper.prepareRedirectOutputForTests();
        TestHelper.givenLibraryHasOneBook(library);
        library.getItems('b').get(0).setUnavailable();
        whenCheckoutBook(1);
        thenShowMessageUnsuccessfulCheckout(outputStream);
    }

}
