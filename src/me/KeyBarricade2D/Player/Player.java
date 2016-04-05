package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.Level.Level;
import me.KeyBarricade2D.Level.Tiles.Barricade;
import me.KeyBarricade2D.Level.Tiles.Key;
import me.KeyBarricade2D.Level.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static me.KeyBarricade2D.input.Input.isPressedOnce;
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

    private boolean noKeyNotification = false;
    private boolean wrongKeyNotification = false;

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

        if(isPressedOnce(W) || isPressedOnce(UP))
            move(UP);

        if(isPressedOnce(A) || isPressedOnce(LEFT))
            move(LEFT);

        if(isPressedOnce(S) || isPressedOnce(DOWN))
            move(DOWN);

        if(isPressedOnce(D) || isPressedOnce(RIGHT))
            move(RIGHT);
    }

    public void move(int keycode) {

        if((Tile(keycode).isPassable()) || ((Tile(keycode).tileType == 2 && key.inPocket())
                && (key.getKeySize() ==((Barricade)Tile(keycode)).getBarricadeSize()))) {
            switch(keycode) {
                case UP:    y -= MOVE_DISTANCE; noKeyNotification = false; wrongKeyNotification = false; break;
                case LEFT:  x -= MOVE_DISTANCE; noKeyNotification = false; wrongKeyNotification = false; break;
                case DOWN:  y += MOVE_DISTANCE; noKeyNotification = false; wrongKeyNotification = false; break;
                case RIGHT: x += MOVE_DISTANCE; noKeyNotification = false; wrongKeyNotification = false; break;
            }

        } else if(Tile(keycode).tileType == 2 && !key.inPocket()){
            noKeyNotification = true;

        }else if(Tile(keycode).tileType == 2 && ((Barricade)Tile(keycode)).getBarricadeSize() != key.getKeySize()) {
            wrongKeyNotification = true;
        }
    }

    public void resetPos(){
        x = this.level.map[1][1].SIZE;
        y = this.level.map[1][10].SIZE * 10;
    }

    private Tile Tile(int keycode) {

        int i = x / 40;
        int j = y / 40;

        switch(keycode) {
            case UP:    j--; break;
            case LEFT:  i--; break;
            case DOWN:  j++; break;
            case RIGHT: i++; break;
        }

        return level.map[j][i];
    }

    public boolean currentTile(int type) {

        yPos = y / 40;
        xPos = x / 40;

        return this.level.map[yPos][xPos].tileType == type;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);

        g.setColor(Color.red);
        if(noKeyNotification){
            g.drawString("You cant go here without a key!", 15, 503);
        }
        if(wrongKeyNotification){
            g.drawString("That key doesn't fit!", 15, 503);
        }

        if(key.inPocket()){
            g.drawString("*  Key size = " + key.getKeySize() + " *" , 150, 503);
        }
    }
}
