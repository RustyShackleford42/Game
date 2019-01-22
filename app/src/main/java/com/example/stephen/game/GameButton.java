package com.example.stephen.game;

import android.graphics.Paint;
import android.graphics.Rect;

public class GameButton {

    private float topLeftX, topLeftY, bottomRightX, bottomRightY;
    private String buttonName, buttonText;
    private Rect buttonRect;

    GameButton(float[] boxPos, String tempButtonName, String tempButtonText){
        topLeftX     = boxPos[0];
        topLeftY     = boxPos[1];
        bottomRightX = boxPos[2];
        bottomRightY = boxPos[3];

        buttonName = tempButtonName;
        buttonText = tempButtonText;

        buttonRect = new Rect((int)topLeftX, (int)topLeftY, (int)bottomRightX, (int)bottomRightY);
    }

    public float[] getBoxPos(){
        float[] boxPos = {topLeftX, topLeftY, bottomRightX, bottomRightY};
        return boxPos;
    }

    public void setBoxPos(float[] boxPos){
        topLeftX     = boxPos[0];
        topLeftY     = boxPos[1];
        bottomRightX = boxPos[2];
        bottomRightY = boxPos[3];
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Rect getButtonRect(){
        return buttonRect;
    }

    public int[] getButtonTextPos(Paint paint){
        int[] pos = {((getButtonRect().width()) / 2), (getButtonRect().height() / 2)};
        return pos;

    }
}
