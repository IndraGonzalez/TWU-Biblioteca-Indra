package com.twu.biblioteca;

import java.util.*;

public class Library {

    private Hashtable<Integer, CheckableItem> itemCollection;

    public Library() {
        itemCollection = new Hashtable<Integer, CheckableItem>();
    }

    public ArrayList<CheckableItem> getItems(char type) {
        ArrayList<CheckableItem> items = new ArrayList<>();

        Enumeration enumeration = itemCollection.elements();
        Object value;
        while( enumeration.hasMoreElements() ){
            value = enumeration.nextElement();
            if(type == 'b' && value instanceof Book) items.add((CheckableItem) value);
            if(type == 'm' && value instanceof Movie) items.add((CheckableItem) value);
        }
        return items;
    }

    public CheckableItem findItem(int id) { return itemCollection.get(id); }

    public void listItems(char type) {
        ArrayList<CheckableItem> items = getItems(type);

        if (items.size() == 0) {
            System.out.println("The library is empty");
            return;
        }

        if (type == 'b') System.out.println(" ---- BOOKS ----");
        if (type == 'm') System.out.println(" ---- MOVIES ----");

        List<String> itemsToPrint = getAvailableItemsList(type);
        printItemsList(itemsToPrint);
    }

    private void printItemsList(List<String> itemsToPrint) {
        Iterator<String> booksIterator = itemsToPrint.iterator();
        while(booksIterator.hasNext()){
            System.out.println(booksIterator.next());
        }
    }


    public List<String> getAvailableItemsList(char type) {
        List<String> itemsToPrint = new ArrayList<String>();

        Enumeration enumeration = itemCollection.elements();
        Object value;
        while( enumeration.hasMoreElements() ){
            value = enumeration.nextElement();
            if(type == 'b' && value instanceof Book && ((Book) value).isAvailable()) itemsToPrint.add(((Book) value).getPrint());
            if(type == 'm' && value instanceof Movie && ((Movie) value).isAvailable()) itemsToPrint.add(((Movie) value).getPrint());
        }
        return itemsToPrint;
    }

    public void addItem(CheckableItem item){
        itemCollection.put(item.getId(),item);
    }


    public void checkoutItem(int id) {
        if(itemCollection.size() == 0) {
            System.out.println("The item is not available: The library is empty");
            return;
        }
        CheckableItem item = itemCollection.get(id);
        if(item != null) item.checkout();
        else System.out.println("The item is not available");
    }

    public void returnItem(int id) {
        CheckableItem item = itemCollection.get(id);
        if(item != null) item.returnItem();
        else System.out.println("That is not a valid item to return");
    }

}
