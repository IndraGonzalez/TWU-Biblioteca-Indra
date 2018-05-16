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
        if((this != null) && (this.isAvailable())) {
            this.setUnavailable();
            System.out.println("Thank you! Enjoy your book");
        }
        else System.out.println("The book is not available");
    }

    public void returnItem(){
        if((this != null) && (!this.isAvailable())) {
            this.setAvailable();
            System.out.println("Thank you for returning your book");
        }
        else System.out.println("That is not a valid book to return");
    }

    public abstract String getPrint();
}
