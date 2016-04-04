package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Barricade extends Tile {

    private boolean opened = false;
    private int barricadeSize;

    public Barricade(String image_src, int barricadeSize) {

        loadImage(image_src);
        this.tileType = 2;
        this.barricadeSize = barricadeSize;
    }

    public void openBarricade() {
        this.opened = true;
    }

    public int getBarricadeSize(){
        return barricadeSize;
    }

    @Override
    public boolean isPassable() {
        return opened;
    }

    @Override
    public BufferedImage getImage() {
            return image;
    }
}
