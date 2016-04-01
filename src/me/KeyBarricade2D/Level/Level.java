package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Level.Tiles.*;
import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Level {

    public Tile[][] map;

    private Player player;

    private ArrayList <BufferedImage> images;

    private int mapWidth;
    private int mapHeight;

    private int tileSize = 40;
    private int currentLevel = 1;

    public void start() {

        loadTiles();
        loadMap();

        player = new Player(210, 250, this);
    }

    public void loadTiles(){

        images = new ArrayList<>();

        try {
            images.add(0, ImageIO.read(new File("Resources/Images/tegel.jpg")));    //ground
            images.add(1, ImageIO.read(new File("Resources/Images/stone.png")));    //wall
            images.add(2, ImageIO.read(new File("Resources/Images/barricade.png")));//barricade
            images.add(3, ImageIO.read(new File("Resources/Images/key.png")));      // key
            images.add(4, ImageIO.read(new File("Resources/Images/goal.png")));     // goal

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded Tiles!");
    }

    public void loadMap(){

        String level = "Resources/Maps/Level" + currentLevel + ".txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(level));

            mapWidth = Integer.parseInt(br.readLine());
            mapHeight = Integer.parseInt(br.readLine());

            map = new Tile[mapHeight][mapWidth];

            for (int i = 0; i < mapHeight; i++) {
                String line = br.readLine();
                String [] numbers = line.split("\\s+");

                for (int j = 0; j < mapWidth; j++) {

                    int x = Integer.parseInt(numbers[j]);
                    switch(x) {
                        case 1:
                            map[i][j] = new Wall(images.get(1));
                            break;
                        case 2:
                            map[i][j] = new Barricade(images.get(2));
                            break;
                        case 3:
                            map[i][j] = new Key(images.get(3));
                            break;
                        case 4:
                            map[i][j] = new Goal(images.get(4));
                            break;
                        default:
                            map[i][j] = new Tile(images.get(0));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Game completed!");
        }
        System.out.println("Loaded Map!");
    }

    public void checkBarricade() {
        if(player.currentTile(2)) {
            if(player.key.obtained) {
                map[player.yPos][player.xPos] = new Tile(images.get(0));
                player.key.obtained = false;
            }
        }
    }

    public void checkGoal() {
        if(player.currentTile(4)) {
            currentLevel++;
            loadMap();
            player.resetPos();
        }
    }

    public void checkKeys() {

        if(player.currentTile(3)) {
            player.key.obtained = true;
            map[player.yPos][player.xPos] = new Tile(images.get(0));
        }
    }

    public void update() {

        player.registerMovement();
        checkKeys();
        checkBarricade();
        checkGoal();
    }

    public void paint(Graphics2D g) {

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                g.drawImage(map[i][j].getImage(), 10 + j * tileSize, 10 + i * tileSize, tileSize, tileSize, null);
            }
            player.paint(g);
        }
    }
}