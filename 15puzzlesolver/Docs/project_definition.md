Project Definition
==================
Purpose
-------
The purpose of the project is to solve 15-puzzles with Java, if they are solvable in the first place.

Algorithm
---------
The puzzle should be solvable by using A* pathfinding algorith, or if memory becomes an issue one of its less memory intensive relatives, to find a path through intermediate states of the puzzle. Heuristic used will be the sum of the manhattan distances of each tile to their correct positions.

To check the solvability of the puzzle, the sum of parity of permutations and the parity of the manhattan distance of empty tile from the lower right position must be even, otherwise the puzzle is unsolvabe.

Data Structures
---------------
Currently only complicated datastructure needed is the priority queue needed to keep track of the open set of gameboard states, with lowest estimated distance from starting state to end state having priority. It will be most likely be implemented with a minimum heap structure.

I/O
---

Current plan is to have a simple GUI to input the initia puzzle, and upon finding the solution, provide the number of steps needed to solution, and  manually go through the intermediate states of the puzzle.