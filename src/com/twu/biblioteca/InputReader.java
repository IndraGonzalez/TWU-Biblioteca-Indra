package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    public static int readNumber() {
        System.out.println("Please, write the reference number of the item:");
        Scanner scanner = new Scanner(System.in);
        int id = -1;
        try
        {
            id = scanner.nextInt();
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Integers only, please.");
        }
        return id;
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
