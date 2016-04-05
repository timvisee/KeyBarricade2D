package me.KeyBarricade2D.Manager;

import me.KeyBarricade2D.Level.Base;

import java.awt.*;

public class GameStateManager {


    /**
     * creating a level object.
     */
    private Base level;

    /**
     * Variable for making sure that the game draws after its loaded.
     */
    private boolean startPainting = false;

    public void update() {

        this.level.update();
    }

    public void loadLevel(Base level) {
        this.level = level;

        this.level.start();

        startPainting = true;
    }

    public void paint(Graphics2D g) {

        if(startPainting)
        this.level.paint(g);
    }
}
