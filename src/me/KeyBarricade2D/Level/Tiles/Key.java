package me.KeyBarricade2D.Level.Tiles;

import java.awt.image.BufferedImage;

public class Key extends Tile {

    private BufferedImage image;
    private boolean obtained = false;
    private int keySize;

    public Key(BufferedImage image, int keySize) {
        super(image);
        this.image = image;
        tileType = 3;
        this.keySize = keySize;
    }

    public Key() {
        tileType = 3;
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
