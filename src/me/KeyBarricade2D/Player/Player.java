package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.Level.Level;
import me.KeyBarricade2D.Level.Tiles.Tile;
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

    private Level level;

    private BufferedImage image;

    public Player(int x, int y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;

        try {
            image = ImageIO.read(new File("Resources/Images/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerMovement() {

        if(isPressed(W) || isPressed(UP))
            move(UP);

        if(isPressed(A) || isPressed(LEFT))
            move(LEFT);

        if(isPressed(S) || isPressed(DOWN))
            move(DOWN);

        if(isPressed(D) || isPressed(RIGHT))
            move(RIGHT);
    }

    public void move(int keycode) {
        switch(keycode) {
            case KeyEvent.VK_UP:
                if(Tile(UP).isPassable()) {
                    this.y -= distance;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(Tile(LEFT).isPassable()) {
                    this.x -= distance;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(Tile(DOWN).isPassable()) {
                    this.y += distance;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(Tile(RIGHT).isPassable()) {
                    this.x += distance;
                }
                break;
            default: break;
        }
        Input.flush();
        resetMoving();
        setMoving(keycode);
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

    private Tile Tile(int keycode) {

        // Current position
        int i = (this.x - 10) / 40;
        int j = (this.y - 10) / 40;

        //System.out.println("Current position: x[" + this.x + "] y[" + this.y + "]");
        System.out.println("Current i[" + i + "] j[" + j + "] type:[" + level.map[i][j].tileType + "]");

        switch(keycode) {
            case KeyEvent.VK_UP:
                // move char up
                j--;
                break;
            case KeyEvent.VK_LEFT:
                // move char left
                i--;
                break;
            case KeyEvent.VK_DOWN:
                // move char down
                j++;
                break;
            case KeyEvent.VK_RIGHT:
                // move char right
                i++;
                break;
        }

        System.out.println("Next    i[" + i + "] j[" + j + "] type:[" + level.map[i][j].tileType + "]");

        return this.level.map[i][j];
    }

    public void setLevel(Level level) {
        this.level = level;
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
