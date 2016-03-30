package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.Level.Level;
import me.KeyBarricade2D.Level.Tiles.Key;
import me.KeyBarricade2D.Level.Tiles.Tile;
import me.KeyBarricade2D.input.Input;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private final int WIDTH = 40;
    private final int HEIGHT = 40;
    private final int MOVE_DISTANCE = 40;

    private int x;
    private int y;

    public int xPos;
    public int yPos;

    private BufferedImage image;
    private Level level;

    public Key key;

    private int W     = KeyEvent.VK_W;
    private int A     = KeyEvent.VK_A;
    private int S     = KeyEvent.VK_S;
    private int D     = KeyEvent.VK_D;

    private int UP    = KeyEvent.VK_UP;
    private int LEFT  = KeyEvent.VK_LEFT;
    private int DOWN  = KeyEvent.VK_DOWN;
    private int RIGHT = KeyEvent.VK_RIGHT;

    public Player(int x, int y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.key = new Key();

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
                if (Tile(UP).isPassable()) {
                    this.y -= MOVE_DISTANCE;
                } else if(Tile(UP).tileType == 2 && key.obtained) {
                    this.y -= MOVE_DISTANCE;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(Tile(LEFT).isPassable()) {
                    this.x -= MOVE_DISTANCE;
                } else if(Tile(LEFT).tileType == 2 && key.obtained) {
                    this.x -= MOVE_DISTANCE;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(Tile(DOWN).isPassable()) {
                    this.y += MOVE_DISTANCE;
                } else if(Tile(DOWN).tileType == 2 && key.obtained) {
                    this.y += MOVE_DISTANCE;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(Tile(RIGHT).isPassable()) {
                    this.x += MOVE_DISTANCE;
                } else if(Tile(RIGHT).tileType == 2 && key.obtained) {
                    this.x += MOVE_DISTANCE;

                }
                break;
        }
        Input.flush();
    }

    public void resetPos(){
        x = 50;
        y = 450;
    }

    private Tile Tile(int keycode) {

        int i= (this.x - 10) / 40;
        int j = (this.y - 10) / 40;

        switch(keycode) {
            case KeyEvent.VK_UP:    j--; break;
            case KeyEvent.VK_LEFT:  i--; break;
            case KeyEvent.VK_DOWN:  j++; break;
            case KeyEvent.VK_RIGHT: i++; break;
        }

        return this.level.map[j][i];
    }

    public boolean currentTile(int type) {

        yPos = (this.y - 10) / 40;
        xPos = (this.x - 10) / 40;

        if(this.level.map[yPos][xPos].tileType == type) {
            return true;
        } else {
            return false;
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private boolean isPressed(int keycode) {
        return Input.isPressed(keycode);
    }

    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }
}
