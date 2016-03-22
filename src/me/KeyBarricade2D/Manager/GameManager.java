package me.KeyBarricade2D.Manager;

import me.KeyBarricade2D.Frame.Frame;
import me.KeyBarricade2D.Frame.FramePanel;

public class GameManager {

    /**
     * Create GameStateManager object.
     */
    private GameStateManager gsm;

    /**
     * Create a Frame object.
     */
    private Frame frame;

    /**
     * Create a FramePanel object.
     */
    private FramePanel framePanel;


    /**
     * Initialize the Game.
     */
    public void init(){

        gsm = new GameStateManager();

        frame = new Frame();
        framePanel = new FramePanel(gsm);

        frame.add(framePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Update the game.
     */
    public void update(){

        gsm.update();

        framePanel.repaint();
    }
}
