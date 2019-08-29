/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.domain;

import com.mycompany.structs.Pair;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for testing Solver-class, testing only that calls work and returns
 * correct objects with correct sized contents
 */
public class SolverTest {

    /**
     * Test that IDAStar call returns something containing a expected sized array
     */
    @Test
    public void testIDAStarCall() {
        PuzzleState root = new PuzzleState(new int[]{1, 7, 8, 2, 3, 5, 0, 6, 4});

        Pair<Long, PuzzleState[]> res = Solver.solve(root, 1);
        
        assertEquals(27, res.getValue().length);
    }
    
    /**
     * Test that IDDFS call returns something containing a expected sized array
     */    
    @Test
    public void testIDDFSCall() {
        PuzzleState root = new PuzzleState(new int[]{1, 7, 8, 2, 3, 5, 0, 6, 4});

        Pair<Long, PuzzleState[]> res = Solver.solve(root, 2);
        
        assertEquals(27, res.getValue().length);        
    }
    
    /**
     * Test that calling nonexistent algorithm returns null
     */
    @Test
    public void testWrongCall() {
        PuzzleState root = new PuzzleState(new int[]{1, 7, 8, 2, 3, 5, 0, 6, 4});

        Pair<Long, PuzzleState[]> res = Solver.solve(root, 3);
        
        assertEquals(null, res);        
    }    
}
