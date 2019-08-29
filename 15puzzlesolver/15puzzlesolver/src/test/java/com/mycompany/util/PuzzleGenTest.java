package com.mycompany.util;

import com.mycompany.domain.PuzzleState;
import static org.junit.Assert.*;
import org.junit.Test;

public class PuzzleGenTest {

    /**
     * Test that returned board state contains correct sized board
     */
    @Test
    public void puzzleGenReturnsCorrectSize() {
        PuzzleState state = PuzzleGen.generate(25, 20);
        
        assertEquals(25, state.getBoard().length);
    }
    
    /**
     * Bit of an overkill, but as starting point is wanted endstate and legal moves 
     * should never result into unusable state test must ensure that every possible
     * move happens
     */
    @Test
    public void puzzleGenReturnsValidAndSolvable() {
        Boolean error = false;
        
        for (int i = 0; i < 20; i++) {
            PuzzleState state = PuzzleGen.generate(25, 40);
            
            if (!state.isValid() || !state.isSolvable()) {
                error = true;
                break;
            }
        }
        
        assertFalse(error);
    }
}
