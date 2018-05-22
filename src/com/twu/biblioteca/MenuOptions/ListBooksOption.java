package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.LibraryManager;

public class ListBooksOption implements MenuOption {

    @Override
    public String getOptionName() {
        return "List books (write 'list books')";
    }

    @Override
    public void run() { LibraryManager.listItems('b'); }

    @Override
    public Boolean display() { return true; }
}
