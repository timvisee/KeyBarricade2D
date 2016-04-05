package me.KeyBarricade2D.Level;

import static me.KeyBarricade2D.input.Input.isPressedOnce;
import static me.KeyBarricade2D.input.key.Keyboard.*;

import java.awt.*;

public class Menu extends Base {

    private String [] choice = {"Start", "Level select", "Quit"};
    private int currentChoice = 0;

    public void start(){}

    public void update(){

        if(isPressedOnce(W) || isPressedOnce(UP)){
            currentChoice--;
        }

        if(isPressedOnce(S) || isPressedOnce(DOWN)){
            currentChoice++;
        }

        // Make sure the current choice doesn't go out of bound
        if(currentChoice < 0) {
            currentChoice = 2;
        } else if(currentChoice > 2) {
            currentChoice = 0;
        }
    }

    public void paint(Graphics2D g){

        g.setBackground(Color.blue);

        for (int i = 0; i < choice.length; i++) {

            if(i == this.currentChoice){
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.black);
            }

            g.drawString(choice[i], 150, 50 + (50 * i));


        }

    }
}
