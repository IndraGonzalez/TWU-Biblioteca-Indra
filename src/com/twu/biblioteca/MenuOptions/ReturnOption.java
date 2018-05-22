package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.InputReader;
import com.twu.biblioteca.LibraryManager;

public class ReturnOption implements MenuOption {

    @Override
    public String getOptionName() { return "Return item (write 'return')"; }

    @Override
    public void run() {
        int id = InputReader.readNumber();
        if(id != -1) LibraryManager.returnItem(id);
    }

    @Override
    public Boolean display() { return true; }
}
