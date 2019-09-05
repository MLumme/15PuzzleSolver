
package com.mycompany.util;

import com.mycompany.domain.PuzzleState;

/**
 * Class for generating valid n-puzzles via randomly moving empty tile
 */
public class PuzzleGen {
    
    /**
     * Generates random n-puzzle
     * @param size length of puzzle board 
     * @param moves number of moves randomly taken starting from endstate
     * @return PuzzleState with randomly generated initial state
     */
    public static PuzzleState generate(int size, int moves) {
        int[] board = new int[size];
        board[size - 1] = 0;

        XORShift rand = new XORShift();
        
        for (int i = 0; i < size - 1; i++) {
            board[i] = i + 1;
        }
        
        PuzzleState state = new PuzzleState(board);
        
        for (int i = 0; i < moves; i++) {
            PuzzleState[] children = state.getChildren();
            
            int accepted = 0;
            PuzzleState[] tempChildren = new PuzzleState[4];
            
            for (int j = 0; j < 4; j++) {
                if (children[j] != null) {
                    tempChildren[accepted] = children[j];
                    accepted++;
                }
            }
            
            children = tempChildren;
            
            state = children[rand.nextInt(accepted)];
        }
        
        //new Puzzlestate from board to purge old states memory of its parent
        return new PuzzleState(state.getBoard());
    }
}
