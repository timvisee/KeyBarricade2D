package me.KeyBarricade2D.Level;

import java.awt.*;

public class Level1 extends BaseLevel {

    private int [][] speelveld =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 5, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 2, 2, 2, 2, 1},
                    {1, 0, 0, 0, 0, 2, 0, 3, 4, 1},
                    {1, 0, 0, 0, 0, 2, 0, 2, 2, 1},
                    {1, 0, 0, 0, 0, 2, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 2, 3, 2, 3, 1},
                    {1, 4, 0, 0, 0, 0, 0, 2, 6, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    @Override
    public void paint(Graphics2D g) {

        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld.length; j++) {

                /**
                 * Color legend
                 * ------------
                 * 0: Default tile
                 * 1: Border tile
                 * 2: Wall tile
                 * 3: Barricade tile
                 * 4: Key tile
                 * 5: Player tile
                 * 6: Exit tile
                 * ------------
                 */
                switch (speelveld[i][j]) {
                    case 1:
                        g.setColor(Color.GREEN);
                        break;
                    case 2:
                        g.setColor(Color.BLUE);
                        break;
                    case 3:
                        g.setColor(Color.YELLOW);
                        break;
                    case 4:
                        g.setColor(Color.BLACK);
                        break;
                    case 5:
                        g.setColor(Color.MAGENTA);
                        break;
                    case 6:
                        g.setColor(Color.CYAN);
                        break;
                    default:
                        g.setColor(Color.RED);
                        break;
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
