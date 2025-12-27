package tic_tac_toe;

import java.awt.*; 
// import java.awt.event.*;
import javax.swing.*;
import tic_tac_toe.tic_tac_toe_logic.winCons;

public class tic_tac_toe_frame extends JFrame {
    tic_tac_toe_logic model;
    private JButton[][] buttons;
    private String [][] board;
    //I do want to eventually use this, just need to get used to my button creation
    private static final int ROWS = 3, COLS = 3, BORDER = 2, SIZE = 1000;
    private static final Color BOARD_COLOUR =  Color.BLACK;

    public tic_tac_toe_frame () {
        model = new tic_tac_toe_logic();
        board = model.initializeBoard();
        setLayout(new GridLayout(ROWS, COLS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = buildGridButtons(ROWS, COLS);

        setSize(1000,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton[][] buildGridButtons (int rows, int cols) {
        JButton [][] buttons = new JButton[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton b = new JButton("Free");
                buttons[r][c] = b;
                final int row = r; 
                final int col = c;

                b.addActionListener(e -> handleClick(row, col));
                add(b);
            }
        }

        return buttons;
    }

    private void handleClick(int row, int col) {
        boolean check = model.turn(board, new tic_tac_toe_logic().readMoveTesting(row, col));
        if (!check) return;

        buttons[row][col].setText(board[row][col]);
        buttons[row][col].setEnabled(false);

        winCons result = model.winCheck(board);
        
        if (result == winCons.PlayerXwins) {
            endGame("X wins!");
        } else if (result == winCons.PlayerOwins) {
            endGame("O wins!");
        } else if (isBoardFull()) {
            endGame("Draw (Cat's game)!");
        }
    }

    private boolean isBoardFull() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == null) return false;
            }
        }
        return true;
    }

    private void endGame(String message) {
        // disable all buttons
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                buttons[r][c].setEnabled(false);
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(tic_tac_toe_frame::new);
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
