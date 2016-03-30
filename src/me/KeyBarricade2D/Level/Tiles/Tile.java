package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Tile {

    public final int SIZE = 40;
    private BufferedImage image;
    public int tileType = 0;

    public Tile(BufferedImage image) {
        this.image = image;
    }

    public Tile() {}

    public boolean isPassable() {
        return true;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
