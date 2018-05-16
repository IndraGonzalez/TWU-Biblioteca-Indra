package com.twu.biblioteca;

import java.util.List;

public abstract class CheckableItem {

    private int id;
    private boolean available = true;

    public CheckableItem(int id) {
        this.id = id;
        this.available = true;
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

    public void checkout(){
        if(available) {
            this.setUnavailable();
            System.out.println("Thank you! Enjoy your item");
        }
        else System.out.println("The item is not available");
    }

    public void returnItem(){
        if(!available) {
            this.setAvailable();
            System.out.println("Thank you for returning your item");
        }
        else System.out.println("That is not a valid item to return");
    }

    public abstract String getPrint();
}
