
package com.mycompany.domain;

/**
 * Class bridging UI and solver algorithm(s)
 */
public class Solver {
    
    /**
     * Solves n-puzzle using IDA*
     * @param initState PuzzleState containing initial state for gameboard
     * @return
     */
    public static PuzzleState[] solveIDAStar(PuzzleState initState) {      
        PuzzleState[] output = typeConversion(IDAStar.runIDAStar(initState).toArray());
        
        return output;
    }
    
    /**
     * Converts Object[] to PuzzleState[]
     * @param input Object[]
     * @return PuzzleState[]
     */
    private static PuzzleState[] typeConversion(Object[] input) {
        PuzzleState[] output = new PuzzleState[input.length];
        
        for (int i = 0; i < input.length; i++) {
            output[i] = (PuzzleState) input[i];
        }
        
        return output;
    }
}
