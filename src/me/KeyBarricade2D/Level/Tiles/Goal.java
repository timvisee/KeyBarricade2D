package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Goal extends Tile {

    private BufferedImage image;
    public int tileType;

    public Goal(BufferedImage image, int tileType) {
        super(image, tileType);
        this.image = image;
        this.tileType = tileType;
    }

    public void finish() {
        //
    }
}
