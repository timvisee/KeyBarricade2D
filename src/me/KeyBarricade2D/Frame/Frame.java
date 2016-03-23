package me.KeyBarricade2D.Frame;

import me.KeyBarricade2D.input.key.InputKeyListener;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    /**
     * Declare frame dimensions
     */
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    public Frame() {

        this.setTitle("Key Barricade");
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Register the input manager key listener
        this.addKeyListener(new InputKeyListener());
  }
}
