package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Goal extends Tile {

    private BufferedImage image;
    public final int TILETYPE = 4;

    public Goal(BufferedImage image) {
        super(image);
        this.image = image;
    }

    public void finish() {
        //
    }
}
