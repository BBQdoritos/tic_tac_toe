package tic_tac_toe;

import java.util.Arrays;
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

    void printBoard (String [][] board) {
        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
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
            startingTurn++;
            return true;
        }
        return false;
    }

    //need somehow to find a line within the grid
    winCons winCheck (String board[][]) {
        //need to make a line using the arrays, so lets start easy and work within a single array
        String playerX = "X";
        String playerO = "O";    

        //if every member of the array is the same, return 
        winCons rowCheck = rowWin(board, playerO, playerX);
        if (rowCheck != winCons.CatsGame) return rowCheck;
        winCons columnCheck = columnWin(board, playerO, playerX);
        if (columnCheck != winCons.CatsGame) return columnCheck;
        winCons diagonalCheck = diagonalWin(board, playerO, playerX);
        if (diagonalCheck != winCons.CatsGame) return diagonalCheck;

        return winCons.CatsGame;
    }

    winCons rowWin (String [][]board, String playerO, String playerX) {
        for (String[] row : board) {
            int Xwin = 0; 
            int Owin = 0; 
            for (String cell : row) { 
                if (cell == null) continue; 
                if (cell.equals(playerO)) Owin++;
                if (cell.equals(playerX)) Xwin++;
            } 

            if (Xwin == 3) return winCons.PlayerXwins;
            if (Owin == 3) return winCons.PlayerOwins; 
        }

        return winCons.CatsGame;
    }

    winCons columnWin (String [][]board, String playerO, String playerX) {
        for (int col = 0; col < 3; col++) {
            int Xwin = 0;
            int Owin = 0;
            
            for (int row = 0; row < 3; row++) {
                String cell = board[row][col];
                if (cell == null) continue;
                if (cell.equals(playerO)) Owin++;
                if (cell.equals(playerX)) Xwin++;
            }
            if (Xwin == 3) return winCons.PlayerXwins;
            if (Owin == 3) return winCons.PlayerOwins; 
        }
        return winCons.CatsGame;
    }


    winCons diagonalWin (String [][]board, String playerO, String playerX) {
        int Xwin = 0;
        int Owin = 0;
        for (int i = 0; i < 3; i++) {
            String cell = board[i][i];
            if (cell == null) continue;
            if (cell.equals(playerO)) Owin++;
            if (cell.equals(playerX)) Xwin++;
        }
        if (Xwin == 3) return winCons.PlayerXwins;
        if (Owin == 3) return winCons.PlayerOwins;
        
        Xwin = 0;
        Owin = 0;
        for (int i = 0; i < 3; i++) {
            String cell = board[i][2 - i];
            if (cell == null) continue;
            if (cell.equals(playerO)) Owin++;
            if (cell.equals(playerX)) Xwin++;
        }
        if (Xwin == 3) return winCons.PlayerXwins;
        if (Owin == 3) return winCons.PlayerOwins;

        return winCons.CatsGame;
    }
    
}