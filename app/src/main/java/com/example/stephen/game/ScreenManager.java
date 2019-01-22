package com.example.stephen.game;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {
    private String currentScreen;
    private List<GameButton> screenButtons;
    private int displayHeight, displayWidth;

    ScreenManager(int tempDisplayHeight, int tempDisplayWidth){
        currentScreen = "battle";
        screenButtons = new ArrayList<>();
        displayHeight = tempDisplayHeight;
        displayWidth = tempDisplayWidth;
    }

    public String getcurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
        setScreenButtons();
    }

    private void setScreenButtons(){
        switch (getcurrentScreen()){
            case "battle":

                //Attack Button
                float[] boxPos = {(displayWidth / 4), displayHeight * 0.75f, displayWidth * 0.75f, displayHeight * 0.90f};
                GameButton testButton = new GameButton(boxPos, "Attack", "Attack");
                screenButtons.add(testButton);

                //add to inventory test button
                float[] boxPos2 = {(displayWidth / 8), displayHeight * 0.60f, displayWidth * 0.4f, displayHeight * 0.70f};
                testButton = new GameButton(boxPos2, "addToInv", "addToInv");
                screenButtons.add(testButton);
                
                //remove from inv test button
                float[] boxPos3 = {displayWidth * 0.5f, displayHeight * 0.60f, displayWidth * 0.8f, displayHeight * 0.70f};
                testButton = new GameButton(boxPos3, "removeFromInv", "removeFromInv");
                screenButtons.add(testButton);


        }
    }

    public List<GameButton> getScreenButtons(){
        return screenButtons;
    }

}
