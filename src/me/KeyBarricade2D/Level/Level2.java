package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.Player.Player;
import java.awt.*;


public class Level2 extends BaseLevel {

    private int [][] speelveld =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    private Player player;

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld.length; j++) {

                switch (speelveld[i][j]) {
                    case 1:
                        g.setColor(Color.GREEN);
                        break;
                    case 2:
                        g.setColor(Color.BLUE);
                        break;
                    default:
                        g.setColor(Color.RED);
                        break;
                }
                g.fillRect(40 + j * 40, 40 + i * 40, 40, 40);
            }
        }

        player.paint(g);
    }

    @Override
    public void start() {

        player = new Player(200, 200, 50, 50);
    }

    @Override
    public void update() {

        player.registerMovement();

    }
}
