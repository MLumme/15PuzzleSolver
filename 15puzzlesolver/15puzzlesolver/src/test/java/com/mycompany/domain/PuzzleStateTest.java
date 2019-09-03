
package com.mycompany.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Markus
 */
public class PuzzleStateTest {
    
    /**
     * Test for getBoard()
     */
    @Test
    public void returnsCorrectBoard() {
        int[] board = new int[]{1,2,3,0};
        PuzzleState state = new PuzzleState(board);
       
        assertArrayEquals(board, state.getBoard());
    }
    
    /**
     * Test for getSize()
     */
    @Test
    public void returnsCorrectSize() {
        int[] board = new int[]{1,2,3,0};
        PuzzleState state = new PuzzleState(board);
       
        assertEquals(2, state.getSize());        
    }

    /**
     * Test that when empty exists getEmpty() correct position in 1D array is returned
     */
    @Test
    public void returnsCorrectLocationForEmpty1() {
        int[] board = new int[]{1,0,2,3};
        PuzzleState state = new PuzzleState(board);
       
        assertEquals(1, state.getEmpty());         
    }
    
    /**
     * Test that when empty doesn't exists getEmpty() return -1 signalling error
     */
    @Test
    public void returnsCorrectLocationForEmpty2() {
        int[] board = new int[]{1,4,2,3};
        PuzzleState state = new PuzzleState(board);
       
        assertEquals(-1, state.getEmpty());         
    }    
    
    /**
     * First in a series of tests to test PuzlleStates getChildren(),
     */
    @Test
    public void returnsCorrectBoardForChildren1() {
        int[] board = new int[]{1,0,2,3};
        int[] boardChild = new int[]{0,1,2,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[2].getBoard());
    }
    
    /**
     * Test that child outside of bound is returned as null
     */
    @Test
    public void returnsCorrectBoardForChildren2() {
        int[] board = new int[]{1,0,2,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[3]);       
    }
    
    /**
     * Test that child outside of bound is returned as null, different direction 
     * from above
     */
    @Test
    public void returnsCorrectBoardForChildren3() {
        int[] board = new int[]{1,0,2,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[0]);       
    }  
    
    /**
     * Still continuing with testing children in different directions
     */
    @Test
    public void returnsCorrectBoardForChildren4() {
        int[] board = new int[]{1,0,2,3};
        int[] boardChild = new int[]{1,3,2,0};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[1].getBoard());
    }
    
    /**
     * Still continuing with testing children in different directions
     */
    @Test
    public void returnsCorrectBoardForChildren5() {
        int[] board = new int[]{1,2,0,3};
        int[] boardChild = new int[]{1,2,3,0};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[3].getBoard());
    }
    
    /**
     * Still continuing with testing children in different directions
     */
    @Test
    public void returnsCorrectBoardForChildren6() {
        int[] board = new int[]{1,2,0,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[2]);       
    }
    
    /**
     * Still continuing with testing children in different directions
     */
    @Test
    public void returnsCorrectBoardForChildren7() {
        int[] board = new int[]{1,2,0,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[1]);       
    }  
    
    /**
     * Still continuing with testing children in different directions
     */
    @Test
    public void returnsCorrectBoardForChildren8() {
        int[] board = new int[]{1,2,0,3};
        int[] boardChild = new int[]{0,2,1,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[0].getBoard());
    }
    
    /**
     * Test for checking that isValid() trips when empty tile not present
     */
    @Test
    public void testValidity1() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isValid());
    }
    
    /**
     * Test for checking that isValid() trips when duplicates present
     */
    @Test
    public void testValidity2() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isValid());
    }
    
     /**
     * Test for checking that isValid() trips when negative numbers present
     */
    @Test
    public void testValidity3() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, -5, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isValid());
    }
    
    /**
     * Test confirming that valid puzzle is indeed recognized as such
     */
    @Test
    public void testValidity4() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isValid());
    }     
    
    /**
     * Tests that solvability is correctly detected in case if even puzzle edge length
     */
    @Test
    public void testSolvabiltyEven1() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isSolvable());
    }
    
    /**
     * Tests that unsolvability is correctly detected in case if even puzzle edge length
     */
    @Test
    public void testSolvabiltyEven2() {
        int[] board = new int[]{2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isSolvable());
    }

    /**
     * Tests that solvability is correctly detected in case if even puzzle edge length,
     * different position of empty as its row changes the number of allowed 
     * inversions in a solvable puzzle
     */
    @Test
    public void testSolvabiltyEven3() {
        int[] board = new int[]{2, 1, 4, 5, 3, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isSolvable());
    }

    /**
     * Testing unsolvabilty with moved empty
     */
    @Test
    public void testSolvabiltyEven4() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isSolvable());
    }  
    
    /**
     * Test solvabilty for odd edge length
     */
    @Test
    public void testSolvabiltyOdd1() {
        int[] board = new int[]{2, 1, 3, 4, 5, 0, 6, 7, 8};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isSolvable());
    }
    
    /**
     * Test solvabilty for odd edge length
     */
    @Test
    public void testSolvabiltyOdd2() {
        int[] board = new int[]{2, 1, 3, 4, 5, 0, 6, 8, 7};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isSolvable());
    }
    
    /**
     * Tests that manhattan heurestic is computed correctly
     */
    @Test
    public void testManhattanHeuristic1() {
        int[] board = new int[]{3, 2, 1, 8, 0, 7, 6, 5, 4};
        
        PuzzleState state = new PuzzleState(board);

        assertEquals(16, state.getManhattanHeuristic());
    }
    
    /**
     * Test for manhattan heuristic for different size of board
     */
    @Test
    public void testManhattanHeuristic2() {
        int[] board = new int[]{2, 1, 0, 3, 7, 9, 8, 10, 5, 4, 11, 13, 14, 6, 12, 15};
        
        PuzzleState state = new PuzzleState(board);

        assertEquals(26, state.getManhattanHeuristic());
    } 
    
    /**
     * Test that isFinal() detects that it is such
     */
    @Test
    public void testIsFinal1() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);

        assertTrue(state.isFinal());
    }
    
    /**
     * Test that isFinal() detects correctly that it is not final state.
     */
    @Test
    public void testIsFinal2() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);

        assertFalse(state.isFinal());
    }
    
    /**
     * Test to when compared to itself equals() returns true
     */
    @Test
    public void testEquals1() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);

        assertTrue(state.equals(state));       
    }
    
    /**
     * Test that equals() detects identical board as equal
     */
    @Test
    public void testEquals2() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState comp = new PuzzleState(board);
        
        assertTrue(state.equals(comp));       
    }    
    
    /**
     * tests that null is also detected as unequal
     */
    @Test
    public void testEquals3() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.equals(null));
    }

    /**
     * Tests that equals() detects incompatible types
     */
    @Test
    public void testEquals4() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.equals("Test"));
    }   
    
    /**
     * Tests that different board is detected as nonequal.
     */
    @Test
    public void testEquals5() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 13, 14, 15};
        int[] compBoard = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState comp = new PuzzleState(compBoard);
        
        assertFalse(state.equals(comp));
    }     
}
