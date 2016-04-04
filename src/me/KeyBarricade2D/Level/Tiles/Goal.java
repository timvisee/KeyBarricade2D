package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Goal extends Tile {

    private final String IMAGE_SRC = "Resources/Images/goal.png";

    public Goal() {

        loadImage(IMAGE_SRC);
        this.tileType = 4;
    }

    public void finish() {
        //
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
