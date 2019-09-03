
package com.mycompany.domain;

import com.mycompany.structs.Pair;

/**
 * Class bridging UI and solver algorithm(s)
 */
public class Solver {
    
    /**
     * Method for passing initial puzzlestate to correct solver-algorithm,
     * returns pair of time taken to find the solution and solution path.
     * @param initState PuzzleState containing initial state of game
     * @param algo int denoting used algorithm
     * @return Pair with execution time and solution path.
     */
    public static Pair<Long, PuzzleState[]> solve(PuzzleState initState, int algo) {
        switch (algo) {
            case 1:
                return solveIDAStar(initState);
            case 2:
                return solveIDDFS(initState);
            default:
                return null;
        }              
    }
    
    /**
     * Solves n-puzzle using IDA*
     * @param initState PuzzleState containing initial state for gameboard
     * @return Pair containing execution time and array of PuzzleStates 
     */
    private static Pair<Long, PuzzleState[]> solveIDAStar(PuzzleState initState) {
        Long tInit = System.nanoTime();
        
        Object[] o = IDAStar.runIDAStar(initState).toArray();
        
        Long tEnd = System.nanoTime();
        
        PuzzleState[] output = typeConversion(o);
        
        return new Pair<>(tEnd - tInit, output);
    }

    /**
     * Solves n-puzzle using IIDFS
     * @param initState PuzzleState containing initial state for gameboard
     * @return Pair containing execution time and array of PuzzleStates 
     */    
    private static Pair<Long, PuzzleState[]> solveIDDFS(PuzzleState initState) {
        Long tInit = System.nanoTime();

        Object[] o = IDDFS.runIDDFS(initState).toArray();
        
        Long tEnd = System.nanoTime();
        
        PuzzleState[] output = typeConversion(o);
        
        return new Pair<>(tEnd - tInit, output);
    }
    
    /**
     * Converts Object[] to PuzzleState[]
     * @param input Object-array
     * @return PuzzleState-array
     */
    private static PuzzleState[] typeConversion(Object[] input) {
        PuzzleState[] output = new PuzzleState[input.length];
        
        for (int i = 0; i < input.length; i++) {
            output[i] = (PuzzleState) input[i];
        }
        
        return output;
    }
}
