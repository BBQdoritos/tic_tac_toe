package tic_tac_toe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import tic_tac_toe.tic_tac_toe_logic.Placement;
import tic_tac_toe.tic_tac_toe_logic.winCons;

public class tic_tac_toeTest {

    
    //need to initalize the logic before I do anything
    tic_tac_toe_logic logic = new tic_tac_toe_logic();

    //Intialization of board success test
    //tests must be annotated with @Test
    @Test
    void initializeBoard_test() {
        String[][] board = logic.initializeBoard();
        assertArrayEquals(board, new String[3][3]); //generally the actual is on the other side
    }

    @Test
    void within_bounds_success() {
        assertTrue(logic.within_bounds(1, 1));
    }

    @Test
    void within_bounds_failure() {
        assertFalse(logic.within_bounds(4, 2));
    }


    @Test 
    void placement_success() {
        // String[][] board = logic.initializeBoard();
        Placement placement = logic.readMoveTesting(0, 0);
        assertEquals(placement, new Placement(0,0));
    }


    @Test
    void first_turn_success() {
        String[][] board = logic.initializeBoard();
        Placement placement = logic.readMoveTesting(0, 0);

        assertTrue(logic.turn(board, placement));
        
        // for (String[] row : board) {
        //     System.out.println(Arrays.toString(row));
        // }
    }

    @Test 
    void first_turn_fail() {
        String[][] board = logic.initializeBoard();
        Placement placement = logic.readMoveTesting(0, 0);
        Placement secondPlacement = logic.readMoveTesting(0, 0);

        assertTrue(logic.turn(board, placement));
        assertFalse(logic.turn(board, secondPlacement));
    }

    @Test
    void row_win_success() {
        String playerX = "X";
        String playerO = "O";    

        String[][] board = logic.initializeBoard();
        Placement placement = logic.readMoveTesting(0, 0);
        Placement secondPlacement = logic.readMoveTesting(1, 0);
        Placement placement3 = logic.readMoveTesting(0, 1);
        Placement placement4 = logic.readMoveTesting(1, 1);
        Placement placement5 = logic.readMoveTesting(0, 2);


        assertTrue(logic.turn(board, placement));
        assertTrue(logic.turn(board, secondPlacement));
        assertTrue(logic.turn(board, placement3));
        assertTrue(logic.turn(board, placement4));
        assertTrue(logic.turn(board, placement5));

        assertEquals(logic.rowWin(board, playerO, playerX), winCons.PlayerOwins);
        logic.printBoard(board);
    }


    @Test
    void col_win_success() {
        String playerX = "X";
        String playerO = "O";    

        String[][] board = logic.initializeBoard();
        Placement placement = logic.readMoveTesting(0, 0);
        Placement secondPlacement = logic.readMoveTesting(1, 1);
        Placement placement3 = logic.readMoveTesting(1, 0);
        Placement placement4 = logic.readMoveTesting(2, 1);
        Placement placement5 = logic.readMoveTesting(2, 0);


        assertTrue(logic.turn(board, placement));
        assertTrue(logic.turn(board, secondPlacement));
        assertTrue(logic.turn(board, placement3));
        assertTrue(logic.turn(board, placement4));
        assertTrue(logic.turn(board, placement5));

        assertEquals(logic.columnWin(board, playerO, playerX), winCons.PlayerOwins);
        logic.printBoard(board);
    }

    @Test
    void diagonal_win_success() {
        String playerX = "X";
        String playerO = "O";    

        String[][] board = logic.initializeBoard();
        Placement placement = logic.readMoveTesting(0, 0);
        Placement secondPlacement = logic.readMoveTesting(0, 1);
        Placement placement3 = logic.readMoveTesting(1, 1);
        Placement placement4 = logic.readMoveTesting(2, 1);
        Placement placement5 = logic.readMoveTesting(2, 2);


        assertTrue(logic.turn(board, placement));
        assertTrue(logic.turn(board, secondPlacement));
        assertTrue(logic.turn(board, placement3));
        assertTrue(logic.turn(board, placement4));
        assertTrue(logic.turn(board, placement5));

        assertEquals(logic.diagonalWin(board, playerO, playerX), winCons.PlayerOwins);
        logic.printBoard(board);
    }




}
