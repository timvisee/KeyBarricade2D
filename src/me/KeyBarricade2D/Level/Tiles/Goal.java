package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Goal extends Tile {

    private BufferedImage image;

    public Goal(BufferedImage image) {
        super(image);
        this.image = image;

        tileType = 4;
    }

    public void finish() {
        //
    }

    @Override
    public boolean hasCollision() {
        return false;
    }
}
