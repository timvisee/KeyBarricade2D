package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Wall extends Tile {

    private BufferedImage image;
    public int tileType;

    public Wall(BufferedImage image, int tileType) {
        super(image, tileType);
        this.image = image;
        this.tileType = tileType;
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
