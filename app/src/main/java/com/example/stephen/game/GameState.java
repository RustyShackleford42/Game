package com.example.stephen.game;

public class GameState {

    PlayerCharacter mainChar;

    /* MANAGERS */
    ScreenManager screenManager;
    BattleManager battleManager;

    /* FLAGS */

    GameState(int tempDisplayHeight, int tempDisplayWidth){
        mainChar = new PlayerCharacter();

        screenManager = new ScreenManager(tempDisplayHeight, tempDisplayWidth);
        battleManager = new BattleManager();

    }

}
