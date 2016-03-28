package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int x;
    private int y;
    private int width;
    private int height;

    public boolean isMovingLeft =  false;
    public boolean isMovingRight=  false;
    public boolean isMovingUp =    false;
    public boolean isMovingDown =  false;

    public Player(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void registerMovement(){

        if(Input.isPressed(KeyEvent.VK_W) || Input.isPressed(KeyEvent.VK_UP)){
            this.y -= 40;
            Input.flush();
            isMovingUp = true;
            isMovingDown = false;
            isMovingRight = false;
            isMovingLeft = false;
        }

        if(Input.isPressed(KeyEvent.VK_S) || Input.isPressed(KeyEvent.VK_DOWN)){
            this.y += 40;
            Input.flush();
            isMovingUp = false;
            isMovingDown = true;
            isMovingRight = false;
            isMovingLeft = false;
        }

        if(Input.isPressed(KeyEvent.VK_D) || Input.isPressed(KeyEvent.VK_RIGHT)){
            this.x += 40;
            Input.flush();
            isMovingUp = false;
            isMovingDown = false;
            isMovingRight = true;
            isMovingLeft = false;
        }

        if(Input.isPressed(KeyEvent.VK_A) || Input.isPressed(KeyEvent.VK_LEFT)){
            this.x -= 40;
            Input.flush();
            isMovingUp = false;
            isMovingDown = false;
            isMovingRight = false;
            isMovingLeft = true;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics2D g){
        g.fillRect(x, y, width, height);
    }

}
