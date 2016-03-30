package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Wall extends Tile {

    private BufferedImage image;

    public Wall(BufferedImage image) {
        super(image);
        this.image = image;

        tileType = 1;
    }

    @Override
    public boolean hasCollision() {
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
