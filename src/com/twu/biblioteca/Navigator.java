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
        System.out.println("List books (write 'list books')");
        System.out.println("Checkout book (write 'checkout book')");
        System.out.println("Return book (write 'return book')");
        System.out.println("List movies (write 'list movies')");
        System.out.println("Checkout movie (write 'checkout movie')");
        System.out.println("Return movie (write 'return movie')");
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
        else if (option.compareTo("list books") == 0) library.listItems('b');
        else if (option.compareTo("list movies") == 0) library.listItems('m');
        else if ((option.compareTo("checkout book") == 0) || (option.compareTo("checkout movie") == 0)){
            int id = getNumber();
            if(id != -1) library.checkoutItem(id);
        }
        else if ((option.compareTo("return book") == 0) || (option.compareTo("return movie") == 0)){
            int id = getNumber();
            if(id != -1) library.returnItem(id);
        }
        else System.out.println("Select valid option!");
    }

    private int getNumber() {
        System.out.println("Please, write the reference number of the item:");
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
