
package com.mycompany.structs;

import com.mycompany.puzzlesolver.PuzzleState;

/**
 *An aray-based FIFO Stack
 */
public class Stack {
   private PuzzleState[] stack;
   private int top;
   private int cap;
   private int minCap = 10;

    /**
     *Constructor for iniitializing stack, initial capacity 10 
     */
    public Stack() {
        cap = 10;
        stack = new PuzzleState[minCap];
        top = 0;
    }
    
    /**
     * Method for getting the size of currently stored stack
     * @return int size
     */
    public int size() {
        return top;
    }
    
    /**
     * Pushes the parameter PuzzleState on tope of the stack, if current 
     * capacity is reached increases it by 3/2*cap+1  
     * @param state
     */
    public void push(PuzzleState state) {
        if (top == cap) {
            grow();
        }
        
        stack[top] = state;
        top++;
    }
   
    /**
     * Peeks the element on top of the stack
     * @return PuzzleState last in
     */
    public PuzzleState peek() {
        if (top <= 0) {
            return null;
        }
        
        return stack[top - 1];
    }
    
    /**
     * Returns the top of the stack and removes it from stack, if size is cap/2
     * shrinks it to (cap-1)*2/3 to save memory
     * @return PuzzleState last in
     */
    public PuzzleState pop() {
        if (top == 0) {
            return null;
        }
        
        top--;
        
        if(top < cap / 2) {
            shrink();
        }
        
        return stack[top];
    }
    
    /**
    *computes new capacity when grown, calls copyToNewStack() to actually change
    * array size
    */
    private void grow() {
        cap = (cap * 3) / 2 + 1;

        copyToNewStack();
    }
    
    /**
    *computes new capacity when shrunken, calls copyToNewStack() to actually change
    * array size
    */    
    private void shrink() {
        if (cap == minCap) {
            return;
        }
        
        cap = (cap - 1) * 2 / 3;
       
        if (cap < minCap) {
            cap = minCap;
        }
        
        copyToNewStack();
    }
    /**
     * Creates new array with capacity cap, and copies old stack entries 
     * to it, replaces original stack with new
     */
    private void copyToNewStack() {
        PuzzleState[] newStack = new PuzzleState[cap];
        
        for (int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }
}
