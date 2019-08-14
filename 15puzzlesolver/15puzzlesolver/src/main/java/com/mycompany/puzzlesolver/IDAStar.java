
package com.mycompany.puzzlesolver;

import com.mycompany.structs.Pair;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class IDAStar {
    static int inf = 999999999;
    
    /**
     * Function for finding path from initial state to target state using IDA*
     * @param root PuzzleState of starting state
     * @return Deque path of states from initial state to final state
     */
    public static Deque<PuzzleState> runIDAStar(PuzzleState root) {
        if (!root.isSolvable()) {
            return null;
        }
        
        int bound = root.getManhattanHeuristic();
        Deque<PuzzleState> path = new ArrayDeque<>();
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
    static Pair<Boolean, Integer> search(Deque<PuzzleState> path, int g, int bound) {
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
            
//            boolean inPath = false;
//            
//            for (PuzzleState storedState: path) {
//                if (Arrays.equals(storedState.getBoard(), child.getBoard())) {
//                    inPath = true;
//                    break;
//                }
//            }
//            
//            if (inPath) {
//                continue;
//            }
            
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
