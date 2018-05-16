package com.twu.biblioteca;

import java.util.List;

public abstract class CheckableItem {

    private int id;
    private boolean available = true;
    private User lendedTo;

    public CheckableItem(int id) {
        this.id = id;
        this.available = true;
        this.lendedTo = null;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setUnavailable() {
        this.available = false;
    }

    public void setAvailable() {
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public void checkout(User user){
        if(available) {
            this.setUnavailable();
            this.lendedTo = user;
            System.out.println("Thank you! Enjoy your item");
        }
        else System.out.println("The item is not available");
    }

    public void returnItem(){
        if(!available) {
            this.setAvailable();
            this.lendedTo = null;
            System.out.println("Thank you for returning your item");
        }
        else System.out.println("That is not a valid item to return");
    }

    public abstract String getPrint();

    public User getLendedTo() {
        return lendedTo;
    }
}
