
package com.mycompany.structs;

import com.mycompany.puzzlesolver.PuzzleState;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    public StackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEmptyStackSize() {
        Stack stack = new Stack();
        
        assertEquals(0, stack.size());
    }
    
    @Test
    public void testEmptyStackPeek() {
        Stack stack = new Stack();
        
        assertEquals(null, stack.peek());
    }
    
    @Test
    public void testEmptyStackPop() {
        Stack stack = new Stack();
        
        PuzzleState res = stack.pop();
        
        assertTrue(res == null && stack.size() == 0);
    }

    @Test
    public void testStackPushSizeInc() {
        Stack stack = new Stack();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);        
        
        assertEquals(1, stack.size());
    }
    
    @Test
    public void testStackPeek() {
        Stack stack = new Stack();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        PuzzleState res = stack.peek();
        
        assertEquals(in, res);
    }   
    
    @Test
    public void testStackPop() {
        Stack stack = new Stack();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        PuzzleState res = stack.pop();
        
        assertTrue(res == in && stack.size() == 0);
    }
    
    @Test
    public void testStackGrowth() {
        Stack stack = new Stack();
        boolean error = false;
        
        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});

        try {
            for (int i = 0; i < 11; i++) {
                stack.push(in);
            }
        } catch (Exception e) {
            error = true;
        }
        
        assertFalse(error);
    }

    @Test
    public void testStackShrinkage() {
        Stack stack = new Stack();
        boolean error = false;
        
        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});

        try {
            for (int i = 0; i < 11; i++) {
                stack.push(in);
            }
            
            for (int i = 0; i < 8; i++) {
                stack.pop();
            }
        } catch (Exception e) {
            error = true;
        }
        
        assertFalse(error);
    }    
}
