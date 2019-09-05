Program Structure
=================

![Class relation diagram](https://github.com/MLumme/15PuzzleSolver/blob/master/15puzzlesolver/Docs/Diagrams/UML2.png)

domain
------

### IDAStar

Class for IDA*-search algorithm for finding shortest path trough the graph of puzzle configurations.

### IDDFS

Class for iterative deepening depth first search for finding shortest path trough the graph of puzzle configurations.

### PuzzleState

Class for storing states of the puzzle, responsible of computing/updating manhattan heuristic, produzong child-states, and remembernig the configuration of its parent board to avoid looping pack to it.

### Solver

Acts as a bridge between UI and the chosen pathfinding algorithm, additionally is responsible of converting algorithms output stack into simple array, and for computiong execution time of the search.

main
----

### Main

main class, does nothing else than starting the GUI.

structs
-------

### Pair

A simple replacement for Javas own Pair, made to use generic types.

### Stack

A implementation of a LIFO stack structure for the use of both the search algorithms, built on top of an array, which is grown and shrunk as elements are added or taken from the stack, replicating operation of Javas ArrayList.

ui
--

### UI

Class for JavaFX-based GUI.

util
----

### PuzzleGen

Class for generating random puzzles of given size and number of steps, uses a sort of random walk starting from solved state of the puzzle, and then randomly selecting one of the valid children of each successive gamestate-node as the next node, using PuzzleStates child generation.

Used Search Algorithms
======================

IDDFS
-----

Iterative Deepening Depth First Search works by iteratively running depth limited depth first search in an attempt to find a route for the correct node, and if it is not found, limit depth is increased by one, old search is discarded, and the entire search is repeated again to the new depth. This algorithm is added as an alternative in the program as an comparison for the effect of IDA*:s heuristic.

IDA*
----

Iterative Deepening A* is variant of IDDFS where the search depth is updated using the minimum for value f = g + h for all the searched node, where g is the cost to reach current node, and h is the heuristic to the targeted state, similarly how A* uses heuristics to choose closest nodes to the goal from the open set to search first. This results in the graph search being directed towards the goal, saving computation time by not chasing states further away from the goal in same numbers as IDDFS.

Expected Time- and Space-performance
------------------------------------

Both IDDFS- and IDA*-algorithms have worst case performances of O(b^d) and space complexity of O(d), where b is the branching factor, ie. average number of child nodes for each node, and d is the depth of the search. In actuality, as noted above, IDA* will be faster than IDDFS due to the used heuristic directing the search towards the correct solution, while IDDFS searches the solution from every direction of the starting node, regardless if they are closer to goal or not.
