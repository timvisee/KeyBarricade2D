package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.Level.Level;
import me.KeyBarricade2D.Level.Tiles.Barricade;
import me.KeyBarricade2D.Level.Tiles.Key;
import me.KeyBarricade2D.Level.Tiles.Tile;
import me.KeyBarricade2D.input.Input;

import javax.imageio.ImageIO;
import java.awt.*;
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

    private boolean noKey = false;
    private boolean wrongKey = false;

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

        if((Tile(keycode).isPassable()) || ((Tile(keycode).tileType == 2 && key.inPocket())
                && (key.getKeySize() ==((Barricade)Tile(keycode)).barricadeSize))) {
            switch(keycode) {
                case UP:    y -= MOVE_DISTANCE; noKey = false; wrongKey = false; break;
                case LEFT:  x -= MOVE_DISTANCE; noKey = false; wrongKey = false; break;
                case DOWN:  y += MOVE_DISTANCE; noKey = false; wrongKey = false; break;
                case RIGHT: x += MOVE_DISTANCE; noKey = false; wrongKey = false; break;
            }

        } else if(Tile(keycode).tileType == 2 && !key.inPocket()){
            noKey = true;

        }else if(Tile(keycode).tileType == 2 && ((Barricade)Tile(keycode)).barricadeSize != key.getKeySize()) {
            wrongKey = true;
        }

        Input.flush();
    }

    public void resetPos(){
        x = this.level.map[1][1].SIZE + 10;
        y = this.level.map[1][10].SIZE * 10 + 10;
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

        yPos = (this.y - 10) / 40;
        xPos = (this.x - 10) / 40;

        return this.level.map[yPos][xPos].tileType == type;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private boolean isPressed(int keycode) {
        return Input.isPressed(keycode);
    }

    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);

        g.setColor(Color.red);
        if(noKey){
            g.drawString("You cant go here without a key!", 15, 510);
        }
        if(wrongKey){
            g.drawString("You have a wrong key!", 15, 510);
        }
    }
}
