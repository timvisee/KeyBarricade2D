package me.KeyBarricade2D.Level;

import java.awt.*;

public class Level1 extends BaseLevel {

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

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld.length; j++) {
                if(speelveld[i][j] == 0){
                    g.setColor(Color.RED);
                }
                if(speelveld[i][j] == 1){
                    g.setColor(Color.green);
                }
                g.fillRect(40 + j * 40, 40 + i * 40, 40, 40);

            }
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }
}
