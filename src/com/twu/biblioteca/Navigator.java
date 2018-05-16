package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Navigator {

    LibraryManager library;
    UserManager userManager;

    public Navigator(LibraryManager library, UserManager userManager) {
        this.library = library;
        this.userManager = userManager;
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to the library :)");
    }

    public void showMenu() {
        System.out.println("\n****************************************");
        System.out.println("MENU: write one option to select");
        System.out.println("List books (write 'list books')");
        System.out.println("List movies (write 'list movies')");
        System.out.println("-----------------------------------------");
        System.out.println("Checkout item (write 'checkout')");
        System.out.println("Return item (write 'return')");
        System.out.println("-----------------------------------------");
        System.out.println("User info (write 'info')");
        if(userManager.userIsLibrarian()) System.out.println("List of checked books (write 'list')");
        System.out.println("Log out (write 'out')");
        System.out.println("Quit (write 'quit')");
        System.out.println("****************************************");
        selectOption();
    }

    public void loginMenu() {
        System.out.println("\nLOG IN");

        System.out.println("User code:");
        String userCode = getInputLine();
        if(!userCode.matches("\\w{3}-\\w{4}")){
            System.out.println("The user code format is not valid: Try XXX-XXXX");
            loginMenu();
        }
        System.out.println("Password:");
        String userPass = getInputLine();
        if(userManager.login(userCode,userPass)) showMenu();
    }

    private void selectOption() {
        String option = getInputLine();
        processOptionCode(option);
        showMenu();
    }

    public String getInputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void processOptionCode(String option) {
        if (option.compareTo("quit") == 0) System.exit(0);
        else if (option.compareTo("list books") == 0) library.listItems('b');
        else if (option.compareTo("list movies") == 0) library.listItems('m');
        else if (option.compareTo("checkout") == 0) {
            int id = getNumber();
            if(id != -1) library.checkoutItem(id,userManager.getCurrentUser());
        }
        else if (option.compareTo("return") == 0) {
            int id = getNumber();
            if(id != -1) library.returnItem(id);
        }
        else if (option.compareTo("list") == 0) {
            library.showLoansList();
        }
        else if (option.compareTo("info") == 0) {
            userManager.showUserInfo();
        }
        else if (option.compareTo("out") == 0) {
            userManager.logout();
            loginMenu();
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
