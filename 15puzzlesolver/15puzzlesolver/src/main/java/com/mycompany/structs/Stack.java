
package com.mycompany.structs;

/**
 *An array-based LIFO Stack
 * @param <T> type parameter
 */
public class Stack<T> {
    private Object[] stack;
    private int top;
    private int cap;
    private final int minCap = 10;

    /**
     *Constructor for initializing stack, initial capacity 10 
     */
    public Stack() {
        cap = 10;
        stack = new Object[minCap];
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
     * @param t object to push into stack
     */
    public void push(T t) {
        if (top == cap) {
            grow();
        }
        
        stack[top] = t;
        top++;
    }
   
    /**
     * Peeks the element on top of the stack
     * @return PuzzleState last in
     */
    public T peek() {
        if (top <= 0) {
            return null;
        }
        
        return (T) stack[top - 1];
    }
    
    /**
     * Returns the top of the stack and removes it from stack, if size is cap/2
     * shrinks it to (cap-1)*2/3 to save memory
     * @return PuzzleState last in
     */
    public T pop() {
        if (top == 0) {
            return null;
        }
        
        top--;
        
        if (top < cap / 2) {
            shrink();
        }
        
        return (T) stack[top];
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
        Object[] newStack = new Object[cap];
        
        for (int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }
    
    /**
     * Checks if parameter is contained within stack
     * @param target Object
     * @return Boolean
     */
    public boolean contains(Object target) {
        if (top == 0) {
            return false;
        }
        
        for (int i = top - 1; i >= 0; i--) {
            if (stack[i].equals(target)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Outputs arrat containing currently stored objects, from first to last 
     * @return Object[]
     */
    public Object[] toArray() {
        Object[] output = new Object[top];
                
        for (int i = 0; i < top; i++) {
            output[i] = stack[i];
        }

        return output;
    }
}
