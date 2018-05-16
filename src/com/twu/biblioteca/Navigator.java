package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Navigator {

    Library library;

    Navigator(Library library) {
        this.library = library;
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to the library :)");
    }

    public void showMenu() {
        System.out.println("\nMENU: select one option");
        System.out.println("List books (write 'list')");
        System.out.println("Checkout book (write 'checkout')");
        System.out.println("Return book (write 'return')");
        System.out.println("Quit (write 'quit')");
        selectOption();
    }

    private void selectOption() {
        String option = getOption();
        processOptionCode(option);
        showMenu();
    }

    public String getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void processOptionCode(String option) {
        if (option.compareTo("quit") == 0) System.exit(0);
        else if (option.compareTo("list") == 0) library.listItems();
        else if(option.compareTo("checkout") == 0){
            System.out.println("Please, write the reference number of the book:");
            int id = getNumber();
            if(id != -1) library.checkoutItem(id);
        }
        else if (option.compareTo("return") == 0){
            System.out.println("Please, write the reference number of the book:");
            int id = getNumber();
            if(id != -1) library.returnBook(id);
        }
        else System.out.println("Select valid option!");
    }

    private int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int id = -1;
        try
        {
            id = scanner.nextInt();
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Integers only, please.");
        }
        return id;
    }
}
