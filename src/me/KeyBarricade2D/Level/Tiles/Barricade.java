package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Barricade extends Tile {

    private BufferedImage image;
    public int tileType;

    public Barricade(BufferedImage image, int tileType) {
        super(image, tileType);
        this.image = image;
        this.tileType = tileType;
    }

    public void remove() {
        //
    }
    public void open() {

        //TODO first check if key has been picked up or is high enough.
        remove();
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
