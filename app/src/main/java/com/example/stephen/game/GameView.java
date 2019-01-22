package com.example.stephen.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.List;

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
    GameManager gameManager;

    InfoTextBox infoTextBox;
    ScreenManager screenManager;

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
        gameManager = new GameManager();
        screenManager = new ScreenManager(displayHeight, displayWidth);
        setGameState("battle");
        infoTextBox = new InfoTextBox();
        infoTextBox.addToTexts(gameManager.mainChar.getPlayerName());


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

            //**** BOXES *****//

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

            //draw buttons
            for(int i=0;i<screenManager.getScreenButtons().size();i++){
                canvas.drawRect(screenManager.getScreenButtons().get(i).getButtonRect(), paint);
            }

            //***** TEXT ******//

            //set paint for drawing text//
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(30);

            //draw text box text
            String[] textBoxItems = infoTextBox.getItems();
            for(int i=0;i<infoTextBox.getNumItems();i++){
                if(i != 0){
                    //TODO: have a line drawn between text items
                }
                canvas.drawText(textBoxItems[i], 60, 100 + i*40, paint);
            }

            //draw text in buttons
            for(int i=0;i<screenManager.getScreenButtons().size();i++){
                GameButton button = screenManager.getScreenButtons().get(i);

                canvas.drawText(button.getButtonText(), button.getButtonTextPos(paint)[0], button.getButtonTextPos(paint)[1], paint);
            }


            holder.unlockCanvasAndPost(canvas);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:

                //add item to infoTextBox
                float touchX = motionEvent.getX();
                float touchY = motionEvent.getY();

                //check where touch was

                //get buttons
                List<GameButton> screenButtons = screenManager.getScreenButtons();

                //create Rect objects for every button
                for(int i=0;i<screenButtons.size();i++) {
                    Rect r = screenButtons.get(i).getButtonRect();

                    //check if touch was in box
                    if(r.contains((int)touchX, (int)touchY)){
                        Log.d("debug", "touch was contained in a box");
                        switch (screenButtons.get(i).getButtonName()) {
                            case "Attack":
                                //print inventory

                                List<InventoryItem> inv = gameManager.mainChar.getInventory();

                                for(int j=0;j<inv.size();j++){
                                    infoTextBox.addToTexts(inv.get(j).getItemName() + "    " + Integer.toString(inv.get(j).getQuantity()));
                                }

                                //infoTextBox.addToTexts("added on touch");
                                break;

                            case "addToInv":
                                //add new item to inventory

                                gameManager.mainChar.addItemToInventory(new Item("potion"));
                                break;

                            case "removeFromInv":
                                //remove item from inventory
                                Log.d("debug", "remove button pressed");
                                gameManager.mainChar.removeItemFromInventory(new Item("potion"));
                                break;
                        }
                    }
                }

                break;

            case MotionEvent.ACTION_DOWN:

                break;
        }
        return true;
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

    //set screen and gamestate at the same time
    private void setGameState(String state){
        gameManager.setGameState(state);
        screenManager.setCurrentScreen(state);
    }


}
