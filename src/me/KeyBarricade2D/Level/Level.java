package me.KeyBarricade2D.Level;
import me.KeyBarricade2D.Level.Tiles.*;
import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Level {

    public Tile [][] map;

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

        player = new Player(210, 250, this);

        loadTiles();
        loadMap();
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
                        case 0:
                            map[i][j] = new Tile(ground);
                            break;
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
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Game completed!");
        }
        System.out.println("Loaded Map!");
    }

    public void checkCollision(){

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {

                if((player.getX() == (j * tileSize + 10) && player.getY() == (i * tileSize + 10) && map[i][j].tileType == 1)){

                    if(player.isMovingLeft){
                        player.setX(player.getX() + 40);
                        player.isMovingLeft = false;
                    }

                    if(player.isMovingRight){
                        player.setX(player.getX() -40);
                        player.isMovingRight = false;
                    }

                    if(player.isMovingUp){
                        player.setY(player.getY() + 40);
                        player.isMovingUp = false;
                    }

                    if(player.isMovingDown){
                        player.setY(player.getY() - 40);
                        player.isMovingDown = false;
                    }
                }

                if((player.getX() == (j * tileSize + 10) && player.getY() == (i * tileSize + 10) && map[i][j].tileType == 4)){
                    currentLevel++;
                    loadMap();
                    player.setX(50);
                    player.setY(410);
                }
            }
        }
    }

    public void update() {

        player.registerMovement();
        checkCollision();
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