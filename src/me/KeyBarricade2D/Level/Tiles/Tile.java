package me.KeyBarricade2D.Level.Tiles;

import me.KeyBarricade2D.Reader.ImageReader;

import java.awt.image.BufferedImage;

public class Tile {

    private final String IMAGE_SRC = "Resources/Images/tegel.jpg";
    public final int SIZE = 40;

    protected BufferedImage image;
    public int tileType = 0;


    public Tile() {
        loadImage(IMAGE_SRC);
    }

    public Tile(String image_src) {
        loadImage(image_src);
    }

    protected void loadImage(String src) {
        ImageReader reader = new ImageReader();

        if(reader.readImage(src) != null) {
            this.image = reader.readImage(src);
        } else {
            // Image returned was null
            System.out.println("image was null.");
        }
    }

    public boolean isPassable() {
        return true;
    }

    public BufferedImage getImage() {
        return this.image;
    }
}
