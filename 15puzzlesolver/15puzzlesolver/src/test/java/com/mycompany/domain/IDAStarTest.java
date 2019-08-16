
package com.mycompany.domain;

import com.mycompany.domain.IDAStar;
import com.mycompany.domain.PuzzleState;
import com.mycompany.structs.Pair;
import com.mycompany.structs.Stack;
import org.junit.Test;
import static org.junit.Assert.*;

public class IDAStarTest {
    
    public IDAStarTest() {
    }

    @Test
    public void testSearchFinal() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 0, 0);
        
        assertTrue(res.getKey());
    }
    
    @Test
    public void testSearchFGreaterThanBound() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 0, 0);

        assertTrue(!res.getKey() && res.getValue() == 1);
    }
    
    @Test
    public void testSearchFEqualsBound1() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        Stack<PuzzleState> path = new Stack<>();
        
        path.push(root);
        
        Pair<Boolean, Integer> res = IDAStar.search(path, 0, root.getManhattanHeuristic());

        assertTrue(res.getKey());        
    }
    
    @Test
    public void testRunIDAStarCatchUnsolvable() {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 6, 5, 7, 8, 0});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(null, path);        
    }
    
    @Test
    public void testRunIDAStar1 () {
        PuzzleState root = new PuzzleState(new int[]{1, 2, 3, 4, 0, 5, 7, 8, 6});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(3, path.size());
    }
    
    @Test
    public void testRunIDAStar2 () {
        PuzzleState root = new PuzzleState(new int[]{1, 7, 8, 2, 3, 5, 0, 6, 4});
        Stack<PuzzleState> path = new Stack<>();
      
        path = IDAStar.runIDAStar(root);
        
        assertEquals(27, path.size());
    }    
}
