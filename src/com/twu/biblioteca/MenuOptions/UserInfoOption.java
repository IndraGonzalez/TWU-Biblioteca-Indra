package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.UserManager;

public class UserInfoOption implements MenuOption {

    @Override
    public String getOptionName() { return "User info (write 'info')"; }

    @Override
    public void run() { UserManager.showUserInfo(); }

    @Override
    public Boolean display() { return true; }
}
