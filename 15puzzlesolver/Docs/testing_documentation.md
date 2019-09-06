Unit Testing
============

![Domain testing coverage](https://github.com/MLumme/15PuzzleSolver/blob/master/15puzzlesolver/Docs/Diagrams/15puzzlesolver.png)

Test coverage testing is possible using both Pit and Jacoco, when using Pit several timeouts will happen, mostly due to mutations causing the search algorithms outer search depth increasing loops to run their full length which should practically never happen.

Domain
------

![Domain testing coverage](https://github.com/MLumme/15PuzzleSolver/blob/master/15puzzlesolver/Docs/Diagrams/domain.png)

### Solver

Solver is tested for errorless operation when calling it for both search algorithms, and that it returns null of it is called for nonexisting algorithm index. 

### Pathfinding algorithms IDA* and IDDFS

Both classes have mostly identical tests, with IDAStar having few more due to its search()-methods need to return, in addition of the boolean denoting if final state has been reached, also its last f-value to update its bound before its next depth iteration. Both classes have some missed instructions due to the presence of somewhat hard to test end condition for the depth increasing iteration, which should stop if the bound of depth search reaches a very large value but is not expected to be reached in this application.

### PuzzleState

PuzzleStates testing covers all of its methods, with most test being dedicated for testing the different child-states resulting from moving the empty tile around, and testing that these moves react correctly to presence of edges of the gameboard, and avoiding moving the empty tile back to current states parent state to avoid loops.

Additional, classes equals()-method is tested for different possible calls ranging from comparing to itself and to objects of completely different class, as equals()-call will in this case come from Stack-datastructures contains()-method, which as generic class will only pass the given comparison target onwards without any checks.

Structs
-------

![Structs testing coverage](https://github.com/MLumme/15PuzzleSolver/blob/master/15puzzlesolver/Docs/Diagrams/structs.png)

### Pair


The generic Pairs testing is accomplished with only two tests testing its getters for key and value, which at the same time test its constructor, although tests could be improved by testing different datatypes.

### Stack

Stack is tested for correct function of its push()-, peek()-, and pop()-methods, and that they change its reported size correctly, and that when Stacks internal object-arrays initial capacity is reached, its size increases to accommodate more objects, and when the number of its contents falls low enough its size is similarly shrunk to save memory without producing errors.

Stacks contains()-method is tested in a way that mostly duplicates the tests for PuzzleStates equals()-method, to confirm that the stack correctly calls and reacts to the method of its stored class.

Util
----

![Util testing coverage](https://github.com/MLumme/15PuzzleSolver/blob/master/15puzzlesolver/Docs/Diagrams/util.png)

### PuzzleGen

Testing for PuzzleGen test only that returned puzzle is of correct size, and that returned puzzle is both valid, e.g. no duplicate numbers or numbers of incorrect size, and solvable.

### ZORShift

Most of the ZORShift-tests only test that constructors work and somthing is returned, as originally I'd attemted to test that averages remain toward the center of the interval, but this being a random number generator, ocassionally average would escape the limits and fail the test, so I removed them, as testing a RNG requires bit more involved testing than its very limited use affords it here. NextInt(n) tested with n=256 and n=300, testing that none of the drawn values is outside of the interval.

UI
--

UI will not be unit tested, due to my unfamiliarity of using JUnit to test JavaFX-derived classes, so manual testing must suffice.

Performance Testing
===================

Testing was done by calculating the average time to compute solutions on both IDA* and IDDFS-algorithms over multiple solution depths, up to 40 steps in case of IDA*, and only up to 10 for IDDFS, due to its slowness. Time for each depth is the average of 200 randomly generated puzzles.

As can be seen in attached figure, as expected, IDA*'s branch pruning produces significant performance increases when compared to IDDFS. As a purely illustrative comparison to theoretical performance O(b^d), I've added plots for branching factors b = 2 and b = 3, with tenuous assumptions that theoretical performance can be compared to actual with equation t = k*b^d, and that constant k can be derived by estimating t to be approx. 1ms for testing machine at d = 1.

![Performance testing](https://github.com/MLumme/15PuzzleSolver/blob/master/15puzzlesolver/Docs/Diagrams/Performances.png)
