package me.KeyBarricade2D.Frame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    public Frame() {

        this.setTitle("Key Barricade");
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
