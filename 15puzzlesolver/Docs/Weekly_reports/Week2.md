Week 2 report
=============

Work done
---------

* Switched from A* to IDA*, causing no loss of work worth mentioning as nothing had been coded yet.
* Coded PuzzleState-class to store current permutation of the puzzle, and to provide methods for checking solvabilty of the puzzle, heuristic needed for pathfinding etc.
* Coded Junit-tests for PuzzleState, everything seemingly working as intended.
* Coded the IDA*-algorithm, using Javas implementation of ArrayDeque, but it has not been yet tested in any way, thus unknown if it will work as is. It should, but you never know.
* All coding is done with expectation of an arbitrary size for game board, as long as it is square. Internally gameboard is stored as 1D-array.

Problems
--------

Still none so far, although I'd expect them to appear once IDA*-implementation is tested for the first time.

Next week
---------

* Start testing IDA*, fix the resulting coding horrors.
* Create a placeholder main program to start running solver from command line, maybe start working on the GUI.
* Start writing a replacement stack for ArrayDeque.
