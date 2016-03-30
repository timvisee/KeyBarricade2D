package me.KeyBarricade2D;

import me.KeyBarricade2D.Level.Level;
import me.KeyBarricade2D.Manager.GameManager;

public class Main {

    public static void main(String[] args) {

        GameManager manager = new GameManager();

        manager.init();
        System.out.println("Initialized game!");

        manager.getGameStateManager().loadLevel(new Level());
        System.out.println("Loading level!");

        manager.getGameStateManager().start();
        System.out.println("Started Game!");

        while(true) {

            manager.update();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
