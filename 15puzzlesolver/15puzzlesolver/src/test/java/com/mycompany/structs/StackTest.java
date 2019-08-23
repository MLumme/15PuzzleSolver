
package com.mycompany.structs;

import com.mycompany.domain.PuzzleState;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for homebrewed stack
 */
public class StackTest {
    
    /**
     * Test that empty stack reports its size as 0 
     */
    @Test
    public void testEmptyStackSize() {
        Stack<PuzzleState> stack = new Stack<>();
        
        assertEquals(0, stack.size());
    }
    
    /**
     * Test that empty stack returns peek as null 
     */
    @Test
    public void testEmptyStackPeek() {
        Stack<PuzzleState> stack = new Stack<>();
        
        assertEquals(null, stack.peek());
    }
    
    /**
     * Test that empty stack returns pop as null, and size remains 0
     */
    @Test
    public void testEmptyStackPop() {
        Stack<PuzzleState> stack = new Stack<>();
        
        PuzzleState res = stack.pop();
        
        assertTrue(res == null && stack.size() == 0);
    }

    /**
     * Test that pushing element into stack increases its size by one 
     */
    @Test
    public void testStackPushSizeInc() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);        
        
        assertEquals(1, stack.size());
    }
    
    /**
     * test that peeking into stack returns pushed element
     */
    @Test
    public void testStackPeek() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        PuzzleState res = stack.peek();
        
        assertEquals(in, res);
    }   
    
    /**
     * test that popping the stack returns pushed element and decreases its size
     */
    @Test
    public void testStackPop() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        PuzzleState res = stack.pop();
        
        assertTrue(res == in && stack.size() == 0);
    }
    
    /**
     * tests that stacks capacity grows when more objects are added than initial
     * capacity
     */
    @Test
    public void testStackGrowth() {
        Stack<PuzzleState> stack = new Stack<>();
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

    /**
     * Tests that shrinking the internal array of the stack does not produce errors
     */
    @Test
    public void testStackShrinkage() {
        Stack<PuzzleState> stack = new Stack<>();
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

    /**
     * Tests for checking contains method when contained object is itself
     */
    @Test
    public void testContains1() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        
        PuzzleState in2 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        stack.push(in2);

        PuzzleState in3 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 6});
        stack.push(in3);
                
        assertTrue(stack.contains(in2));   
    }
    
    /**
     * Test contains when compared object is not itself but identical otherwise
     */
    @Test
    public void testContains2() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        
        PuzzleState in2 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        stack.push(in2);

        PuzzleState in3 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 6});
        stack.push(in3);
                
        PuzzleState comp = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        
        assertTrue(stack.contains(comp));   
    } 
    
    /**
     * Test that contains returns false when target is not within stack
     */
    @Test
    public void testContains3() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        
        PuzzleState in2 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        stack.push(in2);

        PuzzleState in3 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 6});
        stack.push(in3);
                
        PuzzleState comp = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 0, 7, 8});
        
        assertFalse(stack.contains(comp));   
    }
    
    /**
     * Test that stack does not contain null
     */
    @Test
    public void testContains4() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        
        PuzzleState in2 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        stack.push(in2);

        PuzzleState in3 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 6});
        stack.push(in3);
                        
        assertFalse(stack.contains(null));   
    }

    /**
     * Test that stack passes different class object correctly to class equals 
     * method
     */
    @Test
    public void testContains5() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        
        PuzzleState in2 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        stack.push(in2);

        PuzzleState in3 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 6});
        stack.push(in3);
                        
        String comp = "Test";
        
        assertFalse(stack.contains(comp));   
    }
    
    /**
     * Test that empty stack returns false on contains()-call
     */
    @Test
    public void testContains6() {
        Stack<PuzzleState> stack = new Stack<>();
                        
        String comp = "Test";
        
        assertFalse(stack.contains(comp));   
    }    

    /**
     * Test toArray()-method
     */
    @Test
    public void testToArray() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        
        PuzzleState in2 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        stack.push(in2);

        PuzzleState in3 = new PuzzleState(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 6});
        stack.push(in3);
        
        Object[] res = stack.toArray();
        
        assertTrue(res.length == 3 && res[0] == in);   
    }    
}
