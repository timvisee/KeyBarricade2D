package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Level2 extends BaseLevel {

    private int[][] speelveld =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    private BufferedImage grass;
    private BufferedImage stone;

    private Player player;

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld.length; j++) {

                switch (speelveld[i][j]) {

                    case 1:
                        g.drawImage(stone, 10 + j * 40, 10 + i * 40, 40, 40, null);
                        break;

                    case 2:
                        g.setColor(Color.BLUE);
                        break;

                    default:
                        g.drawImage(grass, 10 + j * 40, 10 + i * 40, 40, 40, null);
                        break;
                }
            }
        }

        player.paint(g);
    }

    @Override
    public void start() {

        player = new Player(210, 210, 40, 40);
        stone = loadImage("stone.png");
        grass = loadImage("grass.png");
    }


    @Override
    public void update() {

        player.registerMovement();
    }

    public BufferedImage loadImage(String filename) {

        try {
            return ImageIO.read(getClass().getResourceAsStream("Resources/" + filename));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}