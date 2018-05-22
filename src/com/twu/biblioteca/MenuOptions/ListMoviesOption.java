package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.LibraryManager;

public class ListMoviesOption implements MenuOption {

    @Override
    public String getOptionName() { return "List movies (write 'list movies')"; }

    @Override
    public void run() { LibraryManager.listItems('m'); }

    @Override
    public Boolean display() { return true; }
}
