package com.example.stephen.game;

import java.lang.reflect.Array;

public class EnemyCharacter extends PlayerCharacter {

    private Move[] moves;

    public EnemyCharacter(){
        super();


    }

    public Move[] getMoves() {
        return moves;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }
}
