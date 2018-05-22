package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.LibraryManager;
import com.twu.biblioteca.UserManager;

public class ListCheckoutsOption implements MenuOption {

    @Override
    public String getOptionName() {
        return "List of checked books (write 'list')";
    }

    @Override
    public void run() {
        LibraryManager.showLoansList();
    }

    @Override
    public Boolean display() {
        if(UserManager.getCurrentUser().isLibrarian()) return true;
        else return false;
    }
}
