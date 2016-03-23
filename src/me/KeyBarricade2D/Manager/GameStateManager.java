package me.KeyBarricade2D.Manager;

import me.KeyBarricade2D.Level.BaseLevel;

import java.awt.*;

public class GameStateManager {

    private BaseLevel level;

    public void update() {

        this.level.update();
    }

    public void loadLevel(BaseLevel level){
        this.level = level;
    }

    public void start(){

        this.level.start();
    }

    public void paint(Graphics2D g) {

        this.level.paint(g);
    }
}
