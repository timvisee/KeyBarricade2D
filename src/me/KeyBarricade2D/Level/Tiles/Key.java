package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Key extends Tile {

    private int durability = 0;

    private BufferedImage image;

    public Key(BufferedImage image) {
        super(image);
        this.image = image;

        tileType = 3;
    }

    public void remove() {}

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
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
