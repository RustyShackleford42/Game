package com.example.stephen.game;

public class InventoryItem {

    private Item item;
    private int quantity;

    InventoryItem(Item initialItem, int initialQuantity){

        item = initialItem;
        quantity = initialQuantity;

    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int increaseAmnt){
        quantity += increaseAmnt;
    }

    public String getItemName(){
        return item.getItemName();
    }

}
