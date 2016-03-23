package me.KeyBarricade2D.Level;

import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;

    public Tile(BufferedImage image){

        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
