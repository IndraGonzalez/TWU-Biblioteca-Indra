package com.twu.biblioteca;

import com.twu.biblioteca.MenuOptions.*;

import java.util.Enumeration;
import java.util.Hashtable;

public class Menu {

    private static final String INITIAL_PROMPT = "MENU: write one option to select";
    private static final String INVALID_OPTION_ERROR = "Select valid option!";
    private static final String SEPARATOR = "\n-----------------------------------------\n";

    private static Hashtable<String,MenuOption> options = new Hashtable<>(){{
            put("list books", new ListBooksOption());
            put("list movies", new ListMoviesOption());
            put("checkout", new CheckoutOption());
            put("return", new ReturnOption());
            put("info", new UserInfoOption());
            put("list", new ListCheckoutsOption());
            put("out", new LogOutOption());
            put("quit", new QuitOption());
        }};


    public static void showOptions(){
        System.out.println(SEPARATOR);
        System.out.println(INITIAL_PROMPT);

        Enumeration enumeration = options.elements();
        MenuOption option = null;
        while(enumeration.hasMoreElements()) {
            option = (MenuOption) enumeration.nextElement();
            if (option.display()) System.out.println(option.getOptionName());
        }

        System.out.println(SEPARATOR);
    }

    public static void runOptions(String optionChoice){
        try {
            MenuOption option = options.get(optionChoice);
            option.run();
        } catch (NullPointerException e){
            System.out.println(INVALID_OPTION_ERROR);
        } catch (NumberFormatException e){
            System.out.println(INVALID_OPTION_ERROR);
        } catch (IndexOutOfBoundsException e){
            System.out.println(INVALID_OPTION_ERROR);
        }
    }



}
