package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int x;
    private int y;
    private final int width = 40;
    private final int height = 40;
    private final int distance = 40;

    public boolean isMovingUp = false;
    public boolean isMovingDown = false;
    public boolean isMovingLeft = false;
    public boolean isMovingRight = false;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void registerMovement(){

        if(Input.isPressed(KeyEvent.VK_W) || Input.isPressed(KeyEvent.VK_UP)){
            moveUp();
            isMovingUp = true;
            isMovingDown = false;
            isMovingRight = false;
            isMovingLeft = false;
        }

        if(Input.isPressed(KeyEvent.VK_S) || Input.isPressed(KeyEvent.VK_DOWN)){
            moveDown();
            isMovingUp = false;
            isMovingDown = true;
            isMovingRight = false;
            isMovingLeft = false;
        }

        if(Input.isPressed(KeyEvent.VK_D) || Input.isPressed(KeyEvent.VK_RIGHT)){
            moveRight();
            isMovingUp = false;
            isMovingDown = false;
            isMovingRight = true;
            isMovingLeft = false;
        }

        if(Input.isPressed(KeyEvent.VK_A) || Input.isPressed(KeyEvent.VK_LEFT)){
            moveLeft();
            isMovingUp = false;
            isMovingDown = false;
            isMovingRight = false;
            isMovingLeft = true;
        }
    }

    private void moveUp() {
        this.y -= distance;
        Input.flush();
    }

    private void moveLeft() {
        this.x -= distance;
        Input.flush();
    }

    private void moveDown() {
        this.y += distance;
        Input.flush();
    }

    private void moveRight() {
        this.x += distance;
        Input.flush();
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
