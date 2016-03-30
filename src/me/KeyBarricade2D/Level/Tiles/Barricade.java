package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Barricade extends Tile {

    private BufferedImage image;

    public Barricade(BufferedImage image) {
        super(image);
        this.image = image;

        tileType = 2;
    }

    public void remove() {
        //
    }
    public void open() {

        //TODO first check if key has been picked up or is high enough.
        remove();
    }

    @Override
    public boolean isPassable() {
        return false;
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
