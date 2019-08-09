
package com.mycompany.puzzlesolver;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PuzzleStateTest {
    
    public PuzzleStateTest() {
    }
    
    @Test
    public void returnsCorrectBoard() {
        int[] board = new int[]{1,2,3,0};
        PuzzleState state = new PuzzleState(board);
       
        assertArrayEquals(board, state.getBoard());
    }
    
    @Test
    public void returnsCorrectSize() {
        int[] board = new int[]{1,2,3,0};
        PuzzleState state = new PuzzleState(board);
       
        assertEquals(2, state.getSize());        
    }

    @Test
    public void returnsCorrectLocationForEmpty1() {
        int[] board = new int[]{1,0,2,3};
        PuzzleState state = new PuzzleState(board);
       
        assertEquals(1, state.getEmpty());         
    }
    
    @Test
    public void returnsCorrectLocationForEmpty2() {
        int[] board = new int[]{1,4,2,3};
        PuzzleState state = new PuzzleState(board);
       
        assertEquals(-1, state.getEmpty());         
    }    
    
    @Test
    public void returnsCorrectBoardForChildren1() {
        int[] board = new int[]{1,0,2,3};
        int[] boardChild = new int[]{0,1,2,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[2].getBoard());
    }
    
    @Test
    public void returnsCorrectBoardForChildren2() {
        int[] board = new int[]{1,0,2,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[3]);       
    }
    
    @Test
    public void returnsCorrectBoardForChildren3() {
        int[] board = new int[]{1,0,2,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[0]);       
    }  
    
    @Test
    public void returnsCorrectBoardForChildren4() {
        int[] board = new int[]{1,0,2,3};
        int[] boardChild = new int[]{1,3,2,0};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[1].getBoard());
    }
    
        @Test
    public void returnsCorrectBoardForChildren5() {
        int[] board = new int[]{1,2,0,3};
        int[] boardChild = new int[]{1,2,3,0};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[3].getBoard());
    }
    
    @Test
    public void returnsCorrectBoardForChildren6() {
        int[] board = new int[]{1,2,0,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[2]);       
    }
    
    @Test
    public void returnsCorrectBoardForChildren7() {
        int[] board = new int[]{1,2,0,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertEquals(null, children[1]);       
    }  
    
    @Test
    public void returnsCorrectBoardForChildren8() {
        int[] board = new int[]{1,2,0,3};
        int[] boardChild = new int[]{0,2,1,3};
        
        PuzzleState state = new PuzzleState(board);
        PuzzleState[] children = state.getChildren();
        
        assertArrayEquals(boardChild, children[0].getBoard());
    }

    @Test
    public void testSolvabiltyEven1() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isSolvable());
    }
    
    @Test
    public void testSolvabiltyEven2() {
        int[] board = new int[]{2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isSolvable());
    }

    @Test
    public void testSolvabiltyEven3() {
        int[] board = new int[]{2, 1, 4, 5, 3, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isSolvable());
    }

    @Test
    public void testSolvabiltyEven4() {
        int[] board = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isSolvable());
    }  
    
     @Test
    public void testSolvabiltyOdd1() {
        int[] board = new int[]{2, 1, 3, 4, 5, 0, 6, 7, 8};
        
        PuzzleState state = new PuzzleState(board);
        
        assertFalse(state.isSolvable());
    }
    
    @Test
    public void testSolvabiltyOdd2() {
        int[] board = new int[]{2, 1, 3, 4, 5, 0, 6, 8, 7};
        
        PuzzleState state = new PuzzleState(board);
        
        assertTrue(state.isSolvable());
    }
    
    @Test
    public void testManhattanHeuristic1() {
        int[] board = new int[]{3, 2, 1, 8, 0, 7, 6, 5, 4};
        
        PuzzleState state = new PuzzleState(board);

        assertEquals(16, state.getManhattanHeuristic());
    }
    
    @Test
    public void testManhattanHeuristic2() {
        int[] board = new int[]{2, 1, 0, 3, 7, 9, 8, 10, 5, 4, 11, 13, 14, 6, 12, 15};
        
        PuzzleState state = new PuzzleState(board);

        assertEquals(25, state.getManhattanHeuristic());
    } 
    
    @Test
    public void testIsFinal1() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        
        PuzzleState state = new PuzzleState(board);

        assertTrue(state.isFinal());
    }
    
    @Test
    public void testIsFinal2() {
        int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15};
        
        PuzzleState state = new PuzzleState(board);

        assertFalse(state.isFinal());
    }
}
