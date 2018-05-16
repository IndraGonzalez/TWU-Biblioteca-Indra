package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuTests {

    private Navigator navigator;
    private Library library;

    @Before
    public void initialize() {
        library = new Library();
    }

    @Test
    public void showMessageWithInvalidInput() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        String invalidInput = "adfdsf";

        TestHelper.givenLibraryHasThreeBook(library);
        givenInput(invalidInput);
        whenSelectingOption(invalidInput);
        thenShowMessageInvalidInput(outputStream);

    }

    @Test
    public void listBooksWhenSelectListOption() {
        OutputStream outputStream = prepareRedirectOutputForTests();

        String listInput = "list books";

        TestHelper.givenLibraryHasThreeBook(library);
        givenInput(listInput);
        whenSelectingOption(listInput);
        thenShowListOfBooks(outputStream);

    }
//
//    @Test
//    public void checkoutWhenSelectingOption() {
//        OutputStream outputStream = prepareRedirectOutputForTests();
//
//        String checkout = "checkout";
//
//        TestHelper.givenLibraryHasThreeBook(library);
//        givenInput(checkout);
//        whenSelectingOption(checkout);
//        thenAsksForId(outputStream);
//
//    }

    private void thenAsksForId(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("Please, write the reference number of the book:\n"),0);
    }

    private void thenShowListOfBooks(OutputStream outputStream) {
        assertTrue(outputStream.toString().contains("Harry Potter"));
        assertTrue(outputStream.toString().contains("Robinson Crusoe"));
        assertTrue(outputStream.toString().contains("Frankenstein"));
    }

    private void thenShowMessageInvalidInput(OutputStream outputStream) {
        assertEquals(outputStream.toString().compareTo("Select valid option!\n"), 0);
    }

    private void whenSelectingOption(String input) {
        navigator = new Navigator(library);
        navigator.getOption();
        navigator.processOptionCode(input);
    }

    private void givenInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    private OutputStream prepareRedirectOutputForTests(){

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
        return outputStream;
    }

}