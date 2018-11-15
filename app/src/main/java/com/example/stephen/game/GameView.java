package com.example.stephen.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static android.graphics.Color.WHITE;

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
    InfoTextBox infoTextBox;

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
        infoTextBox = new InfoTextBox();
        infoTextBox.addToTexts(mainChar.getPlayerName());
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
        if(holder.getSurface().isValid()) {
            canvas = holder.lockCanvas();

            //set paint for border
            paint.setColor(WHITE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            //draw border
            canvas.drawRect(10, 10, displayWidth - 10, displayHeight, paint);

            //set paint for battle screen
            paint.setColor(WHITE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            //draw map
            //canvas.drawRect(50, 50, displayWidth - 50, displayHeight / 2, paint);

            //draw text box
            canvas.drawRect(50, 50, displayWidth / 2, displayHeight / 2, paint);

            //draw enemy photo box
            canvas.drawRect((displayWidth / 2) + 50, 50, displayWidth - 50, (displayHeight / 4) - 10, paint);

            //draw stats box
            canvas.drawRect((displayWidth / 2) + 50, (displayHeight / 4) + 10, displayWidth - 50, displayHeight / 2, paint);

            //draw contents of text box

            //set paint for drawing text
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(30);
            String[] textBoxItems = infoTextBox.getItems();
            for(int i=0;i<infoTextBox.getNumItems();i++){
                if(i != 0){
                    //draw line
                }
                canvas.drawText(textBoxItems[i], 60, 100, paint);
            }

            holder.unlockCanvasAndPost(canvas);
        }

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
