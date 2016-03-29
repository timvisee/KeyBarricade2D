package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.input.Input;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private int x;
    private int y;
    private final int width = 40;
    private final int height = 40;
    private final int distance = 40;

    public boolean isMovingUp = false;
    public boolean isMovingLeft = false;
    public boolean isMovingDown = false;
    public boolean isMovingRight = false;

    private int W = KeyEvent.VK_W;
    private int A = KeyEvent.VK_A;
    private int S = KeyEvent.VK_S;
    private int D = KeyEvent.VK_D;

    private int UP = KeyEvent.VK_UP;
    private int LEFT = KeyEvent.VK_LEFT;
    private int DOWN = KeyEvent.VK_DOWN;
    private int RIGHT = KeyEvent.VK_RIGHT;

    private BufferedImage image;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            image = ImageIO.read(new File("Resources/Images/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerMovement() {

        if(isPressed(W) || isPressed(UP))
            move(0);

        if(isPressed(A) || isPressed(LEFT))
            move(1);

        if(isPressed(S) || isPressed(DOWN))
            move(2);

        if(isPressed(D) || isPressed(RIGHT))
            move(3);
    }

    private void move(int move) {
        switch(move) {
            case 0: this.y -= distance; Input.flush(); setMoving(0); break;
            case 1: this.x -= distance; Input.flush(); setMoving(1); break;
            case 2: this.y += distance; Input.flush(); setMoving(2); break;
            case 3: this.x += distance; Input.flush(); setMoving(3); break;
            default: break;
        }
    }

    private boolean isPressed(int keycode) {
        return Input.isPressed(keycode);
    }

    private void setMoving(int keycode) {
        resetMoving();
        switch(keycode) {
            case 0: isMovingUp = true; break;
            case 1: isMovingLeft = true; break;
            case 2: isMovingDown = true; break;
            case 3: isMovingRight = true; break;
            default: break;
        }
    }

    private void resetMoving() {
        isMovingUp = false;
        isMovingLeft = false;
        isMovingDown = false;
        isMovingRight = false;
    }

    public void resetPlayer(){}

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

    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, width, height, null);
    }
}
