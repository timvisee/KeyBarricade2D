package me.KeyBarricade2D.Level;

import java.awt.*;

public class Tile {

    private Image image;

    public Tile(Image image){

        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
