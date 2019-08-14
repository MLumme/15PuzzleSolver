
package com.mycompany.puzzlesolver;

public class PuzzleState {
    private int[] board;
    private int empty;
    private int size;

    /**
     *Constructor for PuzzleState-class
     * @param board 1D int-array containing the puzzle state, in row-major order
     */
    public PuzzleState(int[] board) {
        this.board = board;
        this.size = (int) Math.sqrt(board.length);
        this.empty = locEmpty();
    }

    //Finds the index of empty square denoted by 0, otherwise return -1 to denote
    //error
    private int locEmpty() {       
        for (int i = 0; i < size * size; i++) {
            if (board[i] == 0) {
                return i;
            }   
        }
        
        return -1;
    } 
    
    /**
     * Getter for puzzles board
     * @return 1D int-array containing the puzzle state, in row-major order
     */
    public int[] getBoard() {
        return board;
    }

    /**
     * Getter for the index of the empty square
     * @return int index of empty
     */
    public int getEmpty() {
        return empty;
    }

    /**
     * Getter for the edge length of the puzzle in square form
     * @return
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Computes the Manhattan distance based distance estimation heuristic for 
     * current board
     * @return int h-estimate
     */
    public int getManhattanHeuristic() {
        int counter = 0;
        
        for (int i = 0; i < board.length; i++) {
            if(board[i] != 0 && board[i] != i + 1) {
                counter += (int) Math.abs(i / size - board[i] / size) + 
                    Math.abs(i % size - ((board[i] - 1) % size));
            }
        }
        return counter;
    }
    
    /**
     * Checks if stored state is such that it can eventually result in target state
     * @return boolean denoting if state can be configured to target
     */
    public boolean isSolvable() {
        int inversions = countInversions();
        int emptyRow = size - empty / size;
        
        if (size % 2 == 0 && ((inversions % 2 != 0) != (emptyRow % 2 != 0))) {            
            return true;
        } else if (size % 2 != 0 && inversions % 2 == 0) {
            return true;
        }
        
        return false;
    }
    
    //Helper function to count the number of inversions on gameboard, ignoring 
    //the empty square
    private int countInversions() {
        int counter = 0;
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i] > 0) {
                for (int j = i + 1; j < board.length; j++) {
                    if (board[j] != 0 && board[j] < board[i]) {
                        counter++; 
                    }
                }
            }
        }
        
        return counter;
    }
    
    /**
     * Produces the possible children resulting from moving empty square, if
     * move would put square out of puzzle bounds it is replaced with null in the 
     * array
     * @return 4-element array of PuzzleStates or null-values
     */
    public PuzzleState[] getChildren() {
        PuzzleState[] children = new PuzzleState[4];
        
        if (empty < size) {
            children[0] = null;
        } else {
            children[0] = moveTile(0);
        }
        
        if (empty >= size * (size - 1)) {
            children[1] = null;
        } else {
            children[1] = moveTile(1);
        }
        
        if (empty == 0 || empty % size == 0) {
            children[2] = null;
        } else {
            children[2] = moveTile(2);
        }
        
        if ((empty + 1) % size == 0) {
            children[3] = null;
        } else {
            children[3] = moveTile(3);
        }
        
        return children;
    }
    
    //Helper that makes the tilemoves producing new states
    private PuzzleState moveTile(int dir) {
        int[] newBoard = board.clone();
        
        switch (dir) {
            case 0:
            {
                int temp = newBoard[empty - size];
                newBoard[empty - size] = newBoard[empty];
                newBoard[empty] = temp;
                break;
            }
            case 1:
            {
                int temp = newBoard[empty + size];
                newBoard[empty + size] = newBoard[empty];
                newBoard[empty] = temp;
                break;
            }
            case 2: 
            {
                int temp = newBoard[empty - 1];
                newBoard[empty - 1] = newBoard[empty];
                newBoard[empty] = temp;
                break;
            }
            default:
            {
                int temp = newBoard[empty + 1];
                newBoard[empty + 1] = newBoard[empty];
                newBoard[empty] = temp;
                break;
            }
        }
        
        return new PuzzleState(newBoard);
    } 
    
    /**
     * Check if current state of board is same as target state fo n-puzzle
     * @return boolean true if current state is same as goal
     */
    public boolean isFinal() {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i] != i + 1) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null) {
            return false;
        }
        
        if (this.getClass() != o.getClass()) {
            return false;
        }
        
        PuzzleState target = (PuzzleState) o;
        
        int[] targetBoard = target.getBoard();
        
        for (int i = 0; i < board.length; i++) {
            if (board[i] != targetBoard[i]) {
                return false;
            }
        }
        
        return true;
    }
}
