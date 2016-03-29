package me.KeyBarricade2D.Manager;


import me.KeyBarricade2D.Level.Level;

import java.awt.*;

public class GameStateManager {

    private Level level;

    public void update() {

        this.level.update();
    }

    public void loadLevel(Level level) {
        this.level = level;
    }

    public void start() {

        this.level.start();
    }

    public void paint(Graphics2D g) {

        this.level.paint(g);
    }
}
