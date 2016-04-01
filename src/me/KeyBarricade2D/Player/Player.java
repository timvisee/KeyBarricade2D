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

import static me.KeyBarricade2D.input.key.Keyboard.*;

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
        key = new Key();

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

        if((Tile(keycode).isPassable()) || (Tile(keycode).tileType == 2 && key.obtained)) {
            switch(keycode) {
                case UP:    y -= MOVE_DISTANCE; break;
                case LEFT:  x -= MOVE_DISTANCE; break;
                case DOWN:  y += MOVE_DISTANCE; break;
                case RIGHT: x += MOVE_DISTANCE; break;
            }
        }
        Input.flush();
    }

    public void resetPos(){
        x = 50;
        y = 410;
    }

    private Tile Tile(int keycode) {

        int i = (x - 10) / 40;
        int j = (y - 10) / 40;

        switch(keycode) {
            case UP:    j--; break;
            case LEFT:  i--; break;
            case DOWN:  j++; break;
            case RIGHT: i++; break;
        }

        return level.map[j][i];
    }

    public boolean currentTile(int type) {

        yPos = (y - 10) / 40;
        xPos = (x - 10) / 40;

        return level.map[yPos][xPos].tileType == type;
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
