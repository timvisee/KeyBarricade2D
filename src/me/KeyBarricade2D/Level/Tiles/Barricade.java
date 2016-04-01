package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Barricade extends Tile {

    private BufferedImage image;
    private boolean opened = false;

    public Barricade(BufferedImage image) {
        super(image);
        this.image = image;
        tileType = 2;
    }

    public void open() {
        opened = true;
    }

    @Override
    public boolean isPassable() {
        return opened;
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
