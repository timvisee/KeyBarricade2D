package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Key extends Tile {

    private boolean obtained = false;
    private int keySize;

    public Key(String image_src, int keySize) {

        loadImage(image_src);
        this.tileType = 3;
        this.keySize = keySize;
    }

    public Key() {
        this.tileType = 3;
    }

    public void pickUp() {

       this.obtained = true;
    }

    public void useKey() {

        this.obtained = false;
    }

    public boolean inPocket() {
        return this.obtained;
    }

    public int getKeySize(){
        return keySize;
    }

    public void setKeySize(int keySize){
        this.keySize = keySize;
    }
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
