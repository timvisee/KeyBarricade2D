package me.KeyBarricade2D.Player;

import me.KeyBarricade2D.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int x;
    private int y;
    private int width;
    private int height;

    public Player(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void registerMovement(){

        if(Input.isPressed(KeyEvent.VK_W) || Input.isPressed(KeyEvent.VK_UP)){
            this.y -= 40;
            Input.flush();
        }

        if(Input.isPressed(KeyEvent.VK_S) || Input.isPressed(KeyEvent.VK_DOWN)){
            this.y += 40;
            Input.flush();
        }

        if(Input.isPressed(KeyEvent.VK_D) || Input.isPressed(KeyEvent.VK_RIGHT)){
            this.x += 40;
            Input.flush();
        }

        if(Input.isPressed(KeyEvent.VK_A) || Input.isPressed(KeyEvent.VK_LEFT)){
            this.x -= 40;
            Input.flush();
        }
    }


    public void paint(Graphics2D g){
        g.drawRect(x, y, width, height);
    }

}
