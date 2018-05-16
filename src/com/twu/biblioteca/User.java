package com.twu.biblioteca;

public class User {
    private String id;
    private String password;
    private boolean isLibrarian;
    private String name;
    private String email;
    private String address;
    private int phoneNumber;

    public User(String id, String password, boolean isLibrarian, String name, String email, String address, int phoneNumber) {
        this.id = id;
        this.password = password;
        this.isLibrarian = isLibrarian;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }



    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void printInfo() {
        System.out.println("-- USER INFORMATION --");
        System.out.println("Name: " + name);
        System.out.println("E-mail: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("----------------------");
    }
}
