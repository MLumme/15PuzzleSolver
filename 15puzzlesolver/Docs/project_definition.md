Project Definition
==================
Purpose
-------
The purpose of the project is to solve 15-puzzles, and other n-puzzles, using Java, and initally check that they indeed are solvable.

Algorithm
---------
The puzzle should be solvable by using IDA*-algorith, originally planned to use simple A*, which might still be implemented as an alternative if project advances faster than expected. Heuristic used is the Manhattan distance.

To check sovability of different puzzles, parity of the number of inversions in the gameboard and the parity of the empty square containing row are used.

Data Structures
---------------

Currently, most complicated datastructure needed is a stack structure needed to store the path created by IDA*, and a pair-datastructure, everything else can be implemented using simple arrays.

I/O
---

Current plan is to have a simple GUI to input the initia puzzle, and upon finding the solution, provide the number of steps needed to solution, and  manually go through the intermediate states of the puzzle.
