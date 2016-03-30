package me.KeyBarricade2D.Manager;

import me.KeyBarricade2D.Level.Level;

import java.awt.*;

public class GameStateManager {

    private Level level;
    private boolean startPainting = false;

    public void update() {

        this.level.update();
    }

    public void loadLevel(Level level) {
        this.level = level;
    }

    public void start() {

        this.level.start();
        startPainting = true;
    }

    public void paint(Graphics2D g) {

        if(startPainting)
        this.level.paint(g);
    }
}
