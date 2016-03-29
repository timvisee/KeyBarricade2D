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

    private int W = KeyEvent.VK_W;
    private int A = KeyEvent.VK_A;
    private int S = KeyEvent.VK_S;
    private int D = KeyEvent.VK_D;

    private int UP = KeyEvent.VK_UP;
    private int LEFT = KeyEvent.VK_LEFT;
    private int DOWN = KeyEvent.VK_DOWN;
    private int RIGHT = KeyEvent.VK_RIGHT;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void registerMovement(){

        if(isPressed(W) || isPressed(UP)) {
            moveUp();
            isMovingUp = true;
            isMovingDown = false;
            isMovingRight = false;
            isMovingLeft = false;
        }

        if(isPressed(A) || isPressed(LEFT)) {
            moveLeft();
            isMovingUp = false;
            isMovingDown = false;
            isMovingRight = false;
            isMovingLeft = true;
        }

        if(isPressed(S) || isPressed(DOWN)) {
            moveDown();
            isMovingUp = false;
            isMovingDown = true;
            isMovingRight = false;
            isMovingLeft = false;
        }

        if(isPressed(D) || isPressed(RIGHT)) {
            moveRight();
            isMovingUp = false;
            isMovingDown = false;
            isMovingRight = true;
            isMovingLeft = false;
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

    private boolean isPressed(int keycode) {
        return Input.isPressed(keycode);
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
