package me.KeyBarricade2D.Level.Tiles;
import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    public int tileType = 0;

    public Tile(BufferedImage image) {
        this.image = image;
    }

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
