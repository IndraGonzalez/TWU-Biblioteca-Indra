package com.twu.biblioteca;

public class UserDB {

    public static void setUserDB() {
        UserManager.addUser(new User("111-1111", "password",false,"Hermione","hermione@gmail.com","Hogwarts, Griffindor, girls room",666222666));
        UserManager.addUser(new User("222-2222", "password",true,"Ron","ron@gmail.com","Hogwarts, Griffindor, boys room",666333666));
    }

}
