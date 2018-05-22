package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.InputReader;
import com.twu.biblioteca.LibraryManager;
import com.twu.biblioteca.UserManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckoutOption implements MenuOption{

    @Override
    public String getOptionName() { return "Checkout item (write 'checkout')"; }

    @Override
    public void run() {
        int id = InputReader.readNumber();
        if(id != -1) LibraryManager.checkoutItem(id,UserManager.getCurrentUser());
    }

    @Override
    public Boolean display() { return true; }

}
