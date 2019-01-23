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

                //Text Box
                float[] boxPos = {50f, 50f, displayWidth / 2, displayHeight / 2};
                GameButton testButton = new GameButton(boxPos, "TextBox", "");
                screenButtons.add(testButton);

                //Attack Button
                float[] boxPos2 = {(displayWidth / 4), displayHeight * 0.75f, displayWidth * 0.75f, displayHeight * 0.90f};
                testButton = new GameButton(boxPos2, "Attack", "Attack");
                screenButtons.add(testButton);

                //add to inventory test button
                float[] boxPos3 = {(displayWidth / 8), displayHeight * 0.60f, displayWidth * 0.4f, displayHeight * 0.70f};
                testButton = new GameButton(boxPos3, "addToInv", "addToInv");
                screenButtons.add(testButton);

                //enemy photo box
                float[] boxPos5 = {(displayWidth / 2) + 50, 50, displayWidth - 50, (displayHeight / 4) - 10};
                testButton = new GameButton(boxPos5, "EnemyBox", "");
                screenButtons.add(testButton);

                //stats box
                float[] boxPos6 = {(displayWidth / 2) + 50, (displayHeight / 4) + 10, displayWidth - 50, displayHeight / 2};
                testButton = new GameButton(boxPos6, "StatsBox", "");
                screenButtons.add(testButton);
                
                break;

        }
    }

    public List<GameButton> getScreenButtons(){
        return screenButtons;
    }

}
