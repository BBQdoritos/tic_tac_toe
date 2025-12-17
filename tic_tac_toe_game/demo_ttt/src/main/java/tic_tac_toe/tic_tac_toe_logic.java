package tic_tac_toe;

import java.util.Scanner;

public class tic_tac_toe_logic {
    //user input
    Scanner scanner = new Scanner(System.in);

    int startingTurn = 0;

    public enum winCons {
        PlayerXwins,
        PlayerOwins,
        CatsGame
    }
    //Player 1 = O
    //Player 2 = X

    //How do we get the specific tile that the user wants?
    
    //allow player to put it if the tile is empty
    //need an input here

    String [][] initializeBoard () {
        //a 2D board, should be empty-pop
        return new String[3][3];
    }

    boolean within_bounds (int x, int y) {
        return (0 <= x && x < 3) && (0 <= y && y < 3);
    }

    /**
     * Documentation of a Placement
     * @param x is the row
     * @param y is the column
     * @return the coordinate that the player chose
     */
    record Placement (int x, int y) {}

    Placement readMove () {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Placement(x, y);
    }

    Placement readMoveTesting(int x, int y) {
        return new Placement(x,y);
    } 

    boolean turn (String board[][], Placement placement) {
        int row = placement.x();
        int column = placement.y();

        if (board[row][column] == null && within_bounds(row, column)) {
            board[row][column] = (startingTurn % 2 == 0) ? "O" : "X";
            return true;
        }
        return false;
    }

    //need somehow to find a line within the grid
    winCons winCondition (String board[][]) {
        //need to make a line using the arrays, so lets start easy and work within a single array
        String playerX = "X";
        String playerO = "O";    

        //if every member of the array is the same, return 
        for (String[] row : board) {
            int Xwin = 0;
            int Owin = 0;
            for (String cell : row) {
                if (cell.equals(playerO)) Owin++;
                if (cell.equals(playerX)) Xwin++;
            }
            if (Xwin == 2) return PlayerXwins;
            if(Owin == 2) return PlayerOwins;
        }
    }

}