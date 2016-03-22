package me.KeyBarricade2D;

import me.KeyBarricade2D.Level.Level1;
import me.KeyBarricade2D.Manager.GameManager;

public class Main {

    public static void main(String[] args) {

        GameManager manager = new GameManager();

        manager.init();

        manager.getGameStateManager().loadLevel(new Level1());

        while(true){

            manager.update();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
