package me.KeyBarricade2D.Frame;

import me.KeyBarricade2D.Manager.GameStateManager;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JPanel {

    private GameStateManager gsm;

    public FramePanel(GameStateManager gsm) {

        this.gsm = gsm;
    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        gsm.paint(g2);
    }
}
