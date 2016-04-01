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

        if(isPressed(KeyEvent.VK_W) || isPressed(KeyEvent.VK_UP))
            move(KeyEvent.VK_UP);

        if(isPressed(KeyEvent.VK_A) || isPressed(KeyEvent.VK_LEFT))
            move(KeyEvent.VK_LEFT);

        if(isPressed(KeyEvent.VK_S) || isPressed(KeyEvent.VK_DOWN))
            move(KeyEvent.VK_DOWN);

        if(isPressed(KeyEvent.VK_D) || isPressed(KeyEvent.VK_RIGHT))
            move(KeyEvent.VK_RIGHT);
    }

    public void move(int keycode) {

        switch(keycode) {
            case KeyEvent.VK_UP:
                if (Tile(KeyEvent.VK_UP).isPassable()) {
                    this.y -= MOVE_DISTANCE;
                } else if(Tile(KeyEvent.VK_UP).tileType == 2 && key.obtained) {
                    this.y -= MOVE_DISTANCE;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(Tile(KeyEvent.VK_LEFT).isPassable()) {
                    this.x -= MOVE_DISTANCE;
                } else if(Tile(KeyEvent.VK_LEFT).tileType == 2 && key.obtained) {
                    this.x -= MOVE_DISTANCE;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(Tile(KeyEvent.VK_DOWN).isPassable()) {
                    this.y += MOVE_DISTANCE;
                } else if(Tile(KeyEvent.VK_DOWN).tileType == 2 && key.obtained) {
                    this.y += MOVE_DISTANCE;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(Tile(KeyEvent.VK_RIGHT).isPassable()) {
                    this.x += MOVE_DISTANCE;
                } else if(Tile(KeyEvent.VK_RIGHT).tileType == 2 && key.obtained) {
                    this.x += MOVE_DISTANCE;

                }
                break;
        }
        Input.flush();
    }

    public void resetPos(){
        x = 50;
        y = 410;
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
