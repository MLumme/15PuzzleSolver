
package com.mycompany.structs;

import com.mycompany.domain.PuzzleState;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    public StackTest() {
    }
    
    @Test
    public void testEmptyStackSize() {
        Stack<PuzzleState> stack = new Stack<>();
        
        assertEquals(0, stack.size());
    }
    
    @Test
    public void testEmptyStackPeek() {
        Stack<PuzzleState> stack = new Stack<>();
        
        assertEquals(null, stack.peek());
    }
    
    @Test
    public void testEmptyStackPop() {
        Stack<PuzzleState> stack = new Stack<>();
        
        PuzzleState res = stack.pop();
        
        assertTrue(res == null && stack.size() == 0);
    }

    @Test
    public void testStackPushSizeInc() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);        
        
        assertEquals(1, stack.size());
    }
    
    @Test
    public void testStackPeek() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        PuzzleState res = stack.peek();
        
        assertEquals(in, res);
    }   
    
    @Test
    public void testStackPop() {
        Stack<PuzzleState> stack = new Stack<>();

        PuzzleState in = new PuzzleState(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8});
        stack.push(in);
        PuzzleState res = stack.pop();
        
        assertTrue(res == in && stack.size() == 0);
    }
    
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
    
    @Test
    public void testContains6() {
        Stack<PuzzleState> stack = new Stack<>();
                        
        String comp = "Test";
        
        assertFalse(stack.contains(comp));   
    }    

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
