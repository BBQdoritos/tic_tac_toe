package tic_tac_toe;

import java.awt.*; 
// import java.awt.event.*;
import javax.swing.*;
import tic_tac_toe.tic_tac_toe_logic.winCons;


public class tic_tac_toe_frame extends JFrame {
    tic_tac_toe_logic model;
    private static final int ROWS = 3, COLS = 3, BORDER = 2, SIZE = 65;
    private static final Color BOARD_COLOUR =  Color.BLACK;

    public tic_tac_toe_frame () {
        setLayout(new GridLayout(ROWS, COLS, BORDER, BORDER));
        setBackground(BOARD_COLOUR);

        Board board = new Board(SIZE);

        for (int col = 0; col < COLS; col++) {
            for (int rows = 0; rows < ROWS; rows++) {
                add(board.makeButton())
            }
        }
    }

    // tic_tac_toe_frame () {
    //     jfrm = new JFrame("Tic Tac Toe Beginnings");
    //     model = new tic_tac_toe_logic();

    //     // specify the FlowLayout for the layout manager
    //     jfrm.setLayout(new GridLayout(3, 3)); 

    //     // Give the frame an initial size. 
    //     jfrm.setSize(1000, 800);

    //     // Terminate the program when the user closes the application. 
    //     jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    //     JButton[][] buttons = new JButton[3][3];

    //     //We need an action listener that calls the function turn
    //     //we also need to make it so that buttons is treated as the board




    //     // Display the frame. 
    //     jfrm.setVisible(true);     
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
