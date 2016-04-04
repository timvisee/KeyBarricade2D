package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Level.Tiles.*;
import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
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

            images.add(2, ImageIO.read(new File("Resources/Images/barricade50.png")));//barricade
            images.add(3, ImageIO.read(new File("Resources/Images/barricade100.png")));

            images.add(4, ImageIO.read(new File("Resources/Images/key50.png")));      // key
            images.add(5, ImageIO.read(new File("Resources/Images/key100.png")));

            images.add(6, ImageIO.read(new File("Resources/Images/goal.png")));     // goal

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
                        default:
                            map[i][j] = new Tile(images.get(0));
                            break;
                        case 1:
                            map[i][j] = new Wall(images.get(1));
                            break;
                        case 2:
                            map[i][j] = new Barricade(images.get(2), 50);
                            break;
                        case 3:
                            map[i][j] = new Barricade(images.get(3), 100);
                            break;
                        case 4:
                            map[i][j] = new Key(images.get(4), 50);
                            break;
                        case 5:
                            map[i][j] = new Key(images.get(5), 100);
                            break;
                        case 6:
                        map[i][j] = new Goal(images.get(6));
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
            if(player.key.inPocket()) {
                map[player.yPos][player.xPos] = new Tile(images.get(0));
                player.key.useKey();
                System.out.println("You unlocked a barricade.");
            }
        }
    }

    public void checkKeys() {

        if(player.currentTile(3)) {
            player.key.pickUp();
            player.key.setKeySize(((Key)map[player.yPos][player.xPos]).getKeySize());
            map[player.yPos][player.xPos] = new Tile(images.get(0));
            System.out.println("You picked up a " + player.key.getKeySize() + " key.");
        }
    }

    public void checkGoal() {
        if(player.currentTile(4)) {
            currentLevel++;
            loadMap();
            player.resetPos();
            player.key.useKey();
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
                g.drawImage(map[i][j].getImage(), 10 + j * map[i][j].SIZE, 10 + i * map[i][j].SIZE, map[i][j].SIZE, map[i][j].SIZE, null);
            }
            player.paint(g);
        }
    }
}