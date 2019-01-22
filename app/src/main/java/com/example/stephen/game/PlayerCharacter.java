package com.example.stephen.game;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {

    private String playerName;
    private int health, mana, x, y, numMovesPerTurn;
    private List<InventoryItem> inventory;

    public PlayerCharacter(){
        x = y = health = mana = 50;
        numMovesPerTurn = 3;
        playerName = "Rusty";
        inventory = new ArrayList<>();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = playerName;
    }

    public int getNumMovesPerTurn() {
        return numMovesPerTurn;
    }

    public void setNumMovesPerTurn(int numMovesPerTurn) {
        this.numMovesPerTurn = numMovesPerTurn;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item){
        //if item is already in inventory, replace inv item in inventory
        //with one that has a quantity +1

        boolean wasInInventory = false;

        for(int i=0;i<inventory.size();i++){
            InventoryItem invItem = inventory.get(i);

            if(invItem.getItem().getItemName().equals(item.getItemName())){
                invItem.increaseQuantity(1);
                inventory.set(i, invItem);
                wasInInventory = true;
            }
        }

        if(!wasInInventory){
            inventory.add(new InventoryItem(item, 1));
        }
    }

    public void removeItemFromInventory(Item item){
        for(int i=0;i<inventory.size();i++){
            InventoryItem invItem = inventory.get(i);

            if(invItem.getItem().getItemName().equals(item.getItemName())){
                if(invItem.getQuantity() == 1){
                    inventory.remove(i);
                } else {
                    invItem.increaseQuantity(-1);
                    inventory.set(i, invItem);
                }
            }
        }
    }
}
