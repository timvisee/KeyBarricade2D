package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Key extends Tile {

    private BufferedImage image;
    public boolean obtained = false;
    public int keySize;

    public Key(BufferedImage image, int keySize) {
        super(image);
        this.image = image;
        tileType = 3;
        this.keySize = keySize;
    }

    public Key() {
        tileType = 3;
    }

    public void pickedUp(boolean b) {

        obtained = b;
    }

    public void grab() {

    }

    public void remove() {}

    @Override
    public boolean isPassable() {
        return true;
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
