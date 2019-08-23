Program Structure
=================

Search Algorithms
=================

IDDFS
-----

Iterative Deepening Depth First Search works by iteratively running depth limited depth first search in an attempt to find a route for the correct node, and if it is not found, limit depth is increased by one, old search is discarded, and the entire search is repeated again to the new depth. This algorithm is added as an alternative in the program as an comparison for the effect of IDA*:s heuristic.

IDA*
----

Iterative Deepening A* is variant of IDDFS where the search depth is updated using the minimum for value f = g + h for all the searched node, where g is the cost to reach current node, and h is the heuristic to the targeted state, similarly how A* uses heuristics to choose closest nodes to the goal from the open set to search first. This results in the graph search being directed towards the goal, saving computation time by not chasing states further away from the goal in same numbers as IDDFS.

Expected Time- and Space-performance
------------------------------------

Both IDDFS- and IDA*-algorithms have worst case performances of O(b^d) and space complexity of O(d), where b is the branching factor, ie. average number of child nodes for each node, and d is the depth of the search. In actuality, as noted above, IDA* will be faster than IDDFS due to the used heuristic directing the search towards the correct solution, while IDDFS searches the solution from every direction of the starting node, regardless if they are closer to goal or not.
