package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Level.Tiles.*;
import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Level {

    public Tile[][] map;

    private Player player;

    private BufferedImage stone;
    private BufferedImage ground;
    private BufferedImage key;
    private BufferedImage barricade;
    private BufferedImage goal;

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

        try {
            stone       = ImageIO.read(new File("Resources/Images/stone.png"));
            ground      = ImageIO.read(new File("Resources/Images/tegel.jpg"));
            key         = ImageIO.read(new File("Resources/Images/key.png"));
            barricade   = ImageIO.read(new File("Resources/Images/barricade.png"));
            goal        = ImageIO.read(new File("Resources/Images/goal.png"));

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
                            map[i][j] = new Wall(stone);
                            break;
                        case 2:
                            map[i][j] = new Barricade(barricade);
                            break;
                        case 3:
                            map[i][j] = new Key(key);
                            break;
                        case 4:
                            map[i][j] = new Goal(goal);
                            break;
                        default:
                            map[i][j] = new Tile(ground);
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
                map[player.yPos][player.xPos] = new Tile(ground);
                System.out.println(player.xPos + " " + player.yPos);
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
            map[player.yPos][player.xPos] = new Tile(ground);
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