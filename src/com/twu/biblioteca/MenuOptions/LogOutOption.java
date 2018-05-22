package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Navigator;
import com.twu.biblioteca.UserManager;

public class LogOutOption implements MenuOption {

    @Override
    public String getOptionName() {
        return "Log out (write 'out')";
    }

    @Override
    public void run() {
        UserManager.logout();
        Navigator.showLogIn();
    }

    @Override
    public Boolean display() {
        return true;
    }
}
