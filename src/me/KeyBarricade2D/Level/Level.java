package me.KeyBarricade2D.Level;
import me.KeyBarricade2D.Level.Tiles.Barricade;
import me.KeyBarricade2D.Level.Tiles.Key;
import me.KeyBarricade2D.Level.Tiles.Tile;
import me.KeyBarricade2D.Level.Tiles.Wall;
import me.KeyBarricade2D.Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Level {

    private Tile [][] map;

    private Player player;

    private BufferedImage stone;
    private BufferedImage ground;
    private BufferedImage key;
    private BufferedImage barricade;

    private int mapWidth;
    private int mapHeight;

    private int tileSize = 40;

    public void start() {

        player = new Player(210, 250);

        System.out.println("Loading tiles...");
        loadTiles();

        System.out.println("Loading map...");
        loadMap();

    }

    public void loadTiles(){

        try {
            stone       = ImageIO.read(new File("Resources/stone.png"));
            ground      = ImageIO.read(new File("Resources/tegel.jpg"));
            key         = ImageIO.read(new File("Resources/key.png"));
            barricade   = ImageIO.read(new File("Resources/barricade.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("testmap.txt"));

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
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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