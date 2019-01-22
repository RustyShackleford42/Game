package com.example.stephen.game;

import java.util.ArrayList;
import java.util.List;

public class BattleManager {

    //constants
    private static final int PLAYER = 0;
    private static final int ENEMY  = 1;

    private boolean isPlayerTurn;
    private int turnCount;
    private List<PlayerCharacter> playerAndEnemy;


    BattleManager(){
        turnCount = 0;
    }

    public void beginBattle(boolean surprise, PlayerCharacter playerCharacter, EnemyCharacter enemyCharacter){
        if(surprise){
            isPlayerTurn = false;
        } else {
            isPlayerTurn = true;
        }

        playerAndEnemy = new ArrayList<>();
        playerAndEnemy.add(playerCharacter);
        playerAndEnemy.add(enemyCharacter);

        processTurn();
    }

    public void endTurn(){
        turnCount++;
    }

    public List<PlayerCharacter> endBattle(){
        return playerAndEnemy;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void processTurn(){

    }
}
