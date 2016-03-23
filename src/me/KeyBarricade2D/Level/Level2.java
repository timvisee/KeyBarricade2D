package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class Level2 extends BaseLevel {

    private int[][] map;

    private BufferedImage grass;
    private BufferedImage stone;

    private Player player;

    private int mapWidth;
    private int mapHeight;

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j <  mapWidth; j++) {

                switch (map[i][j]) {

                    case 1:
                        g.drawImage(stone, 10 + j * 40, 10 + i * 40, 40, 40, null);
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

        loadMap();
        player = new Player(210, 210, 40, 40);

        stone = loadImage("stone.png");
        grass = loadImage("tegel.jpg");
    }


    public void loadMap(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("testmap.txt"));

            mapWidth = Integer.parseInt(br.readLine());
            mapHeight = Integer.parseInt(br.readLine());

            map = new int[mapHeight][mapWidth];

            for (int i = 0; i < mapHeight; i++) {
                String line = br.readLine();
                String [] numbers = line.split("\\s+");

                for (int j = 0; j < mapWidth; j++) {
                    map[i][j] = Integer.parseInt(numbers[j]);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage loadImage(String filename) {

        try {
            return ImageIO.read(getClass().getResourceAsStream("Resources/" + filename));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {

        player.registerMovement();
    }
}
