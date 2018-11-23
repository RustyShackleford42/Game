package com.example.stephen.game;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {
    private String currentLevel;
    private List<GameButton> screenButtons;
    private int displayHeight, displayWidth;

    ScreenManager(int tempDisplayHeight, int tempDisplayWidth){
        currentLevel = "battle";
        screenButtons = new ArrayList<>();
        displayHeight = tempDisplayHeight;
        displayWidth = tempDisplayWidth;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
        setScreenButtons();
    }

    private void setScreenButtons(){
        switch (getCurrentLevel()){
            case "battle":

                //Attack Button
                float[] boxPos = {(displayWidth / 4), displayHeight * 0.75f, displayWidth * 0.75f, displayHeight * 0.90f};
                GameButton testButton = new GameButton(boxPos, "Attack", "Attack");
                screenButtons.add(testButton);
        }
    }

    public List<GameButton> getScreenButtons(){
        return screenButtons;
    }
}
