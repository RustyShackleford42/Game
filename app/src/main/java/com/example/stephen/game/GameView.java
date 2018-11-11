package com.example.stephen.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    volatile boolean playing;
    Thread gameThread = null;

    //for drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder holder;
    int displayHeight, displayWidth;

    //Game objects
    PlayerCharacter mainChar;
    EnemyCharacter rat;

    public GameView(Context context) {
        super(context);

        //For getting display size
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayHeight = displayMetrics.heightPixels;
        displayWidth = displayMetrics.widthPixels;

        //initialize drawing objects
        holder = getHolder();
        paint = new Paint();

        //initialize game objects
        mainChar = new PlayerCharacter();
        rat = new EnemyCharacter();
        rat.setPlayerName("Rat");
        rat.setX(100);
        rat.setY(100);

        Attack attack = new Attack();
        Move[] ratMoves = {attack};

        rat.setMoves(ratMoves);

    }

    @Override
    public void run(){
        while(playing){
            update();
            draw();
            control();
        }
    }

    private void update(){

    }

    private void draw(){



    }

    private void control(){

        try {
            gameThread.sleep(17);
        }catch (InterruptedException e){

        }

    }

    //clean up thread if game is interrupted or player quits
    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e){

        }
    }

    //make a new threat and start it
    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
