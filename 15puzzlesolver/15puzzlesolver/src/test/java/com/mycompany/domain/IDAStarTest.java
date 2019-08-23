
package com.mycompany.domain;

import com.mycompany.structs.Pair;
import com.mycompany.structs.Stack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for unit testing IDAStar-class
 */
public class IDAStarTest {

    /**
     * Test that when search is given final state it immediately returns true
     */
    @Test
    public void testSearchFinal() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 0, 0);
        
        assertTrue(res.getKey());
    }
    
    /**
     * Test that when F-value exceeds bound end state reached is reported as false,
     * and new bound is correct
     */
    @Test
    public void testSearchFGreaterThanBound() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 0, 0);

        assertTrue(!res.getKey() && res.getValue() == 1);
    }
    
    /**
     * Test that when search() is given bound known to be enough to reach goal
     * it does
     */
    @Test
    public void testSearchFEqualsBound1() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 0, root.getManhattanHeuristic());

        assertTrue(res.getKey());        
    }
    
    /**
     * Tests that IDAStars solvability-test trips as expected
     */
    @Test
    public void testRunIDAStarCatchUnsolvable() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 6, 5, 7, 8, 0});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(null, path);        
    }

    /**
     * Tests that IDAStars validity-test trips as expected
     */
    @Test
    public void testRunIDAStarCatchNonValid() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 3, 6, 5, 7, 8, 9});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(null, path);        
    }
    
    /**
     * Test that solvable puzzle actually is and produces correct known solution
     * length
     */
    @Test
    public void testRunIDAStar1 () {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 0, 5, 7, 8, 6});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(3, path.size());
    }
    
    /**
     * Test that solvable puzzle actually is and produces correct known solution
     * length
     */
    @Test
    public void testRunIDAStar2 () {
        PuzzleState root = new PuzzleState(new int[]{1, 7, 8, 2, 3, 5, 0, 6, 4});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(27, path.size());
    } 
    
    /**
     * Only exists to test in Jacoco and Pit that children already in path are 
     * detected
     */
    @Test
    public void testCollisionWithPath () {
        PuzzleState node = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});        
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 0, 7, 8});
        
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        path.push(node);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 1, 2);
        
        assertTrue(res.getKey());
    }
}
