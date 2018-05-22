package com.twu.biblioteca;

import com.twu.biblioteca.MenuOptions.*;

import java.util.*;


public class Navigator {

    public static void run(){
        UserDB.setUserDB();
        ItemsDB.setItemsDB();

        showWelcomeMessage();
        showLogIn();

        showMenu();
    }

    private static void showMenu() {
        Menu.showOptions();
        Menu.runOptions(InputReader.readLine());
        showMenu();
    }

    public static void showLogIn() {
        System.out.println("\nLOG IN");

        System.out.println("User code:");
        String userCode = InputReader.readLine();
        if(!userCode.matches("\\w{3}-\\w{4}")){
            System.out.println("The user code format is not valid: Try XXX-XXXX");
            showLogIn();
        }
        System.out.println("Password:");
        String userPass = InputReader.readLine();
        if(UserManager.login(userCode,userPass)) showMenu();
    }


    public static void showWelcomeMessage() { System.out.println("Welcome to the library :)"); }


}

