Week 3 report
=============

Work done
---------

* Tested IDA*, fixed issues relating to PuzzleStates children being returned in array which may contain null-values which caused exception.
* Wrote replacement for Deque, Stack, which is a simple array-based LIFO stack
* Made tests for Stack
* Also replaced java.utils Pair with homecooked version, which utilizes generic types, in case for some reason might need it for something else than IDA*.

Questions
---------

Unclear are we allowed to use relatively simple inbuilt algoriths, such as Arrays.equals, or must that too be replaced with selfmade version, as it is reltively simple loop?

Next week
---------

* Actually get to coding the GUI finally.
* Maybe switch Stack to use generic types, to enable recycling of it.
* Replace current Deque in IDA* with stack, not done yet as Stack still need a small method for checking if it contains parameter object.
* Begin working on full set of documents.
* Still thinking of adding alternative algorithm for pathsearch, as current amount of time spent coding feels insufficient.
