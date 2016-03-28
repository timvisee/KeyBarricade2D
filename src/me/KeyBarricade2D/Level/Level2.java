package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Player.Player;

import java.awt.*;
import java.io.*;



public class Level2 extends BaseLevel {

    private int[][] map;

    private Image grass;
    private Image stone;

    private Player player;

    private int mapWidth;
    private int mapHeight;

    private int tileSize = 40;


    @Override
    public void start() {

        player = new Player(210, 250, 40, 40);
        loadMap();

        stone = Toolkit.getDefaultToolkit().getImage(Level2.class.getResource("Resources/stone.png"));
        grass = Toolkit.getDefaultToolkit().getImage(Level2.class.getResource("Resources/tegel.jpg"));
    }

    public void checkCollision(){

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {

                if((player.getX() == (j * tileSize + 10) && player.getY() == (i * tileSize + 10)) && map[i][j] == 1){

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

        checkCollision();

    }

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j <  mapWidth; j++) {

                if (map[i][j] == 1) {
                    g.drawImage(stone, 10 + j * tileSize, 10 + i * tileSize, tileSize, tileSize, null);
                }
                if(map[i][j]== 0) {
                    g.drawImage(grass, 10 + j * tileSize, 10 + i * tileSize, tileSize, tileSize, null);
                    }
                }

            }
        player.paint(g);
        }
    }
