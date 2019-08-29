
package com.mycompany.domain;

import com.mycompany.structs.Stack;

/**
 * Class for searching shortest path to goalstate using iterative deepening 
 * depth first search
 */
public class IDDFS {
    static int inf = Integer.MAX_VALUE;
    
    public static Stack<PuzzleState> runIDDFS(PuzzleState root) {
        if(!root.isValid() || !root.isSolvable()) {
            return null;
        }
        
        Stack<PuzzleState> path = new Stack<>();
        Boolean found;
        
        path.push(root);
        
        for (int bound = 0; bound < inf; bound++) {
            found = search(path, bound);
            
            if (found) {
                return path;
            }
        }
        
        return null;
    }
    /**
     * function for the actual depth first search to maximum depth of bound,
     * as distances between nodes are constant 1 bound is just decreased during 
     * recursive calls
     */
    static Boolean search(Stack<PuzzleState> path, int bound) {
        PuzzleState state = path.peek();
        
        if(bound == 0) {
            return state.isFinal();
        }
        
        PuzzleState[] children = state.getChildren();
        
        for (PuzzleState child: children) {
            if (child == null) {
                continue;
            }
            
            if (path.contains(child)) {
                continue;
            }
            
            path.push(child);
            
            Boolean found = search(path, bound - 1);
            
            if (found == true) {
                return true;
            }
            
            path.pop();
        }
        
        return false;
    }
}
