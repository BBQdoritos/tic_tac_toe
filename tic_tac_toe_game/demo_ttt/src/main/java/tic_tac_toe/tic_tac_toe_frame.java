package tic_tac_toe;

import java.awt.*; 
// import java.awt.event.*;
import javax.swing.*;



public class tic_tac_toe_frame {
    JFrame jfrm; 
    int b = 0;
    int start = 0;

    tic_tac_toe_frame () {
        JFrame jfrm = new JFrame("Tic Tac Toe Beginnings");

        // specify the FlowLayout for the layout manager
        jfrm.setLayout(new GridLayout(3, 3)); 

        // Give the frame an initial size. 
        jfrm.setSize(1000, 800);

        // Terminate the program when the user closes the application. 
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("Free");
                // button.addActionListener(this);
                jfrm.add(button);
            }
        }

        //action listeners for each button


        // Display the frame. 
        jfrm.setVisible(true);     
    }


    // public bool tic_tac_toe_logic (int n) {
    //     if (n % 2 == 0) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // public void itemStateChanged (ItemEvent ie, int n) {
    //     JButton button = (JButton)ie.getItem();

    //     /*
    //         The button being selected should always be true, so no need to have it here
    //         as it will act as a hinderance in the logic, or would it?

    //     */

    //     if (button.isSelected()) {
    //         if (tic_tac_toe_logic(n)) {
    //             jfrm.
    //         }
    //     }

    // }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
                new tic_tac_toe_frame(); 
            } 
        }); 
    }
}

/*
Notes:

we are getting somewhere!

so now we need to make a grid using buttons, and I kind of want to implement a MVC archecture, but the book says that Java
uses something called Model-Delegate

to do this, we need to implement two things:
    1. the model
    2. the UI delegate


UI is essentially done for the game, now we need to make the logic and action listeners for it 

*/
