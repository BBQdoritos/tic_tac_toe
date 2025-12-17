package tic_tac_toe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tic_tac_toeTest {

    
    //need to initalize the logic before I do anything
    tic_tac_toe_logic logic = new tic_tac_toe_logic();

    //Intialization of board success test
    //tests must be annotated with @Test
    @Test
    void initializeBoard_test() {
        String[][] board = logic.initializeBoard();
        assertArrayEquals(board, new String[3][3]);
    }


}
