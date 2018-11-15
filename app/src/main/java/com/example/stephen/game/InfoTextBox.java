package com.example.stephen.game;

public class InfoTextBox {
    int textItems;
    String[] texts;

    InfoTextBox(){
        textItems = 0;
        texts = new String[100];
    }

    public int getNumItems(){
        return textItems;
    }

    public void setTextItems(int textItems) {
        this.textItems = textItems;
    }

    public String[] getItems(){
        return texts;
    }

    public void addToTexts(String item){
        texts[getNumItems()] = item;
        textItems++;
    }
}
