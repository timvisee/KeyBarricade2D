package me.KeyBarricade2D.Level;

import java.awt.*;

public class Level1 extends BaseLevel {


    private int x = 50;
    private int y = 50;

    @Override
    public void paint(Graphics2D g) {

        g.setColor(Color.green);
        g.fillRect(0, 0, 500, 500);

        g.setColor(Color.BLACK);
        g.drawRect(150, 150, x, y);
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

        x += 1;
        y += 1;
    }
}
