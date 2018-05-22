package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.MenuOptions.MenuOption;

public class QuitOption implements MenuOption {
    
    @Override
    public String getOptionName() { return "Quit (write 'quit')"; }

    @Override
    public void run() { System.exit(0); }

    @Override
    public Boolean display() { return true; }
}
