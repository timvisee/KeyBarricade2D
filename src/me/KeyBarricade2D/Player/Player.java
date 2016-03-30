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

        if (isPressed(W) || isPressed(UP)) {
            //move(UP);
            setMoving(UP);
            System.out.println("Move UP set");
            System.out.println(isMovingUp);
        }

        if (isPressed(A) || isPressed(LEFT)) {
            //move(LEFT);
            setMoving(LEFT);
            System.out.println("Move LEFT set");
            System.out.println(isMovingLeft);
        }

        if(isPressed(S) || isPressed(DOWN)) {
            //move(DOWN);
            setMoving(DOWN);
            System.out.println("Move DOWN set");
            System.out.println(isMovingDown);
        }

        if(isPressed(D) || isPressed(RIGHT)) {
            //move(RIGHT);
            setMoving(RIGHT);
            System.out.println("Move RIGHT set");
            System.out.println(isMovingRight);
        }
    }

    public void move(int keycode) {
        switch(keycode) {
            case KeyEvent.VK_UP:    this.y -= distance; break;
            case KeyEvent.VK_LEFT:  this.x -= distance; break;
            case KeyEvent.VK_DOWN:  this.y += distance; break;
            case KeyEvent.VK_RIGHT: this.x += distance; break;
            default: break;
        }
        Input.flush();
        resetMoving();
        System.out.println("x: " + this.x + ", y: " + this.y);
    }

    private void setMoving(int keycode) {
        resetMoving();
        switch(keycode) {
            case KeyEvent.VK_UP:    isMovingUp    = true; break;
            case KeyEvent.VK_LEFT:  isMovingLeft  = true; break;
            case KeyEvent.VK_DOWN:  isMovingDown  = true; break;
            case KeyEvent.VK_RIGHT: isMovingRight = true; break;
            default: break;
        }
    }

    private void resetMoving() {
        isMovingUp    = false;
        isMovingLeft  = false;
        isMovingDown  = false;
        isMovingRight = false;
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

    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, width, height, null);
    }
}
