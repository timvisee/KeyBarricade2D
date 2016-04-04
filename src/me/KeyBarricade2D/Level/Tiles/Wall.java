package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Wall extends Tile {

    private final String IMAGE_SRC = "Resources/Images/stone.png";

    public Wall() {

        loadImage(IMAGE_SRC);
    }

    public Wall(String image_src) {

        loadImage(image_src);
        this.tileType = 1;
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
