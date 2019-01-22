package com.example.stephen.game;

public class Item {

    private String itemName;

    public Item(String name){
        itemName = name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
