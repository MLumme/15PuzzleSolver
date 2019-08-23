
package com.mycompany.domain;

import com.mycompany.structs.Pair;
import com.mycompany.structs.Stack;

/**
 * Class for running an IDA* based shortest path search
 */
public class IDAStar {
    static int inf = Integer.MAX_VALUE;
    
    /**
     * Function for finding path from initial state to target state using IDA*
     * @param root PuzzleState of starting state
     * @return Stack path of states from initial state to final state
     */
    public static Stack<PuzzleState> runIDAStar(PuzzleState root) {
        if (!root.isValid() || !root.isSolvable()) {
            return null;
        }
        
        int bound = root.getManhattanHeuristic();
        Stack<PuzzleState> path = new Stack<>();
        Pair<Boolean, Integer> t;
        
        path.push(root);
        
        while (true) {
            t = search(path, 0, bound);
            
            if (t.getKey()) {
                return path;
            }
            
            if (t.getValue() == inf) {
                return null;
            }
            
            bound = t.getValue();
        }
    }
    
    //function for the actual depth first search to maximum depth of bound
    static Pair<Boolean, Integer> search(Stack<PuzzleState> path, int g, int bound) {
        PuzzleState state = path.peek();
        int f = g + state.getManhattanHeuristic();
        
        if (f > bound) {
            return new Pair<>(false, f);
        } else if (state.isFinal()) {
            return new Pair<>(true, f);
        }
        
        int min = inf;
        
        PuzzleState[] children = state.getChildren();
        
        for (PuzzleState child: children) {
            if (child == null) {
                continue;
            }
            
            if (path.contains(child)) {
                continue;
            }
            
            path.push(child);
                    
            Pair<Boolean, Integer> t = search(path, g + 1, bound);
            
            if (t.getKey()) {
                return new Pair<>(true, f);
            } 
            
            if (t.getValue() < min) {
                min = t.getValue();
            }
            
            path.pop();
        }
        
        return new Pair<>(false, min);
    }

}
