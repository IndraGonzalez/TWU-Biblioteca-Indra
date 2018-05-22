package com.twu.biblioteca;

import java.util.Hashtable;

public class UserManager {

    private static User currentUser;
    private static Hashtable<String, User> userDatabase = new Hashtable<>();

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Hashtable<String, User> getUserDatabase() {
        return userDatabase;
    }

    public static void addUser(User user) {
        userDatabase.put(user.getId(),user);
    }

    public static boolean userIsLibrarian() {
        return currentUser.isLibrarian();
    }

    public static boolean login(String userCode, String userPass) {
        User user = userDatabase.get(userCode);
        if(user != null){
            if(user.getPassword().compareTo(userPass) == 0){
                System.out.println("Login successful");
                currentUser = user;
                return true;
            } else {
                System.out.println("ERROR: Wrong password");
                return false;
            }
        }
        System.out.println("ERROR: User not found");
        return false;
    }

    public static void showUserInfo() {
        currentUser.printInfo();
    }

    public static void logout() {
        currentUser = null;
    }
}
