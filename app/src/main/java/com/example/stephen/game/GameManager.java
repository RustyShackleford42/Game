package com.example.stephen.game;

public class GameManager {

    public PlayerCharacter mainChar;

    private String gameState;

    /* MANAGERS */
    private BattleManager battleManager;

    /* FLAGS */

    GameManager(){
        mainChar = new PlayerCharacter();

        battleManager = new BattleManager();

    }

    public void setGameState(String state){
        gameState = state;
    }

    public String getGameState(){
        return gameState;
    }

}