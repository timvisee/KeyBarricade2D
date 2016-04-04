package me.KeyBarricade2D.Reader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    public BufferedImage readImage(String src) {
        try {
            return ImageIO.read(new File(src));
        } catch(IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
