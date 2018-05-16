package com.twu.biblioteca;

import java.util.Hashtable;

public class UserManager {

    private User currentUser;
    private Hashtable<String, User> userDatabase;

    public UserManager() {
        userDatabase = new Hashtable<>();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Hashtable<String, User> getUserDatabase() {
        return userDatabase;
    }

    public void addUser(User user) {
        userDatabase.put(user.getId(),user);
    }

    public boolean userIsLibrarian() {
        return currentUser.isLibrarian();
    }

    public boolean login(String userCode, String userPass) {
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

    public void showUserInfo() {
        currentUser.printInfo();
    }

    public void logout() {
        currentUser = null;
    }
}
