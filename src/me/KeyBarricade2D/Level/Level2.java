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
    public void start() {

        player = new Player(210, 210, 40, 40);
        loadMap();

        try {
            stone = ImageIO.read(getClass().getResourceAsStream("Resources/stone.png"));
            grass = ImageIO.read(getClass().getResourceAsStream("Resources/tegel.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @Override
    public void update() {

        player.registerMovement();
    }

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j <  mapWidth; j++) {

                if (map[i][j] == 1) {
                    g.drawImage(stone, 10 + j * 40, 10 + i * 40, 40, 40, null);
                }
                if(map[i][j]== 0) {
                    g.drawImage(grass, 10 + j * 40, 10 + i * 40, 40, 40, null);
                    }
                }

            }
        player.paint(g);
        }
    }
