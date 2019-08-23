Unit Testing
============

Testing is possible using both Pit and Jacoco, when using Pit several timeouts will happen, mostly due to mutations causing the search algorithms outer search depth increasing loops to run their full length which should practically never happen.

Domain
======

Solver
------

Solver has currently no test in place yet, WIP.

Search algorithms IDAStar and IDDFS
-----------------------------------

Both classes have mostly identical tests, with IDAStar having few more due to its search()-methods need to return, in addition of the boolean denoting if final state has been reached, also its last f-value to update its bound before its next depth iteration. Both classes have some missed instructions due to the presence of somewhat hard to test end condition for the depth increasing iteration, which should stop if the bound of depth search reaches a very large value but is not expected to be reached in this application.

PuzzleState
-----------

PuzzleStates testing covers all of its methods, with most test being dedicated for testing the different child-states resulting from moving the empty tile around, and testing that these moves react correctly to presence of edges of the gameboard, and avoiding moving the empty tile back to current states parent state to avoid loops.

Additional, classes equals()-method is tested for different possible calls ranging from comparing to itself and to objects of completely different class, as equals()-call will in this case come from Stack-datastructures contains()-method, which as generic class will only pass the given comparison target onwards without any checks.

Structs
=======

Pair
----

The generic Pairs testing is accomplished with only two tests testing its getters for key and value, which at the same time test its constructor, although tests could be improved by testing different datatypes.

Stack
-----

Stack is tested for correct function of its push()-, peek()-, and pop()-methods, and that they change its reported size correctly, and that when Stacks internal object-arrays initial capacity is reached, its size increases to accommodate more objects, and when the number of its contents falls low enough its size is similarly shrunk to save memory without producing errors.

Stacks contains()-method is tested in a way that mostly duplicates the tests for PuzzleStates equals()-method, to confirm that the stack correctly calls and reacts to the method of its stored class.

Util
====

PuzzleGen
---------

Not yet tested, tests WIP.

UI
==

UI will not be unit tested, due to my unfamiliarity of using JUnit to test JavaFX-derived classes.

Performance Testing
===================

Not yet, will compare the IDDFS and IDA* for some smallish n-puzzles, n over 15 starts to cause massive slowdowns in IDDFS due to the amount of possible states and duplication of them during the search.
