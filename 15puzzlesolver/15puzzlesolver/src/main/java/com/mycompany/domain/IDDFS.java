
package com.mycompany.domain;

import com.mycompany.structs.Pair;
import com.mycompany.structs.Stack;
import java.util.Arrays;

/**
 * Class for searching shortest path to goalstate using iterative deepening 
 * depth first search
 */
public class IDDFS {
    static int inf = 999999999;
    
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
