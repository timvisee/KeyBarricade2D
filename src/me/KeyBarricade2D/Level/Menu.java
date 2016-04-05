package me.KeyBarricade2D.Level;

import me.KeyBarricade2D.input.Input;
import static me.KeyBarricade2D.input.key.Keyboard.*;

import java.awt.*;

public class Menu extends Base {

    private String [] choice = {"Start", "Level select", "Quit"};
    private int currentChoice = 0;

    public void start(){}

    public void update(){

        if(Input.isPressed(W) && currentChoice == 0){
            currentChoice = 2;
        }

        if(Input.isPressed(W) && currentChoice != 0){
            currentChoice--;
        }
        if(Input.isPressed(S) && currentChoice == 2){
            currentChoice = 0;
        }
        if(Input.isPressed(S) && currentChoice != 2){
            currentChoice++;
        }
    }

    public void paint(Graphics2D g){

        g.setBackground(Color.blue);

        for (int i = 0; i < choice.length; i++) {

            if(i == this.currentChoice){
                g.setColor(Color.BLUE);
            }
            else {
                g.setColor(Color.black);
            }
            g.drawString(choice[i], 150, 50 + (50 * i));


        }

    }
}
