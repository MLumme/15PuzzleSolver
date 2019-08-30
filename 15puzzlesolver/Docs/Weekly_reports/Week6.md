Week 6 report
=============

Work done
---------

* Constructed a small command-line using main for running larger batches of puzzles for testing.
* Started performance testing, came to conclusion that something needs to be streamlined, as IDDFS is quite slow, maybe unexpectedly so.
* Fixed some issues noted in peer review.
* Attemted to speed up program by changing the way how heuristics are calculate (and refactored it several times, which was the greatest timesink), as currently every time they are calculated the comute the entire arrays heuristic again, in experimental branch new way is to initally compute the entire array, and later update value based on only on how moved tile effects it.


Problems
--------
Attemted improvement of heuristic resulted into exactly opposite result than expected, hence why it is currently corraled into experimental branch, have some ideas how to maybe fix it, but remains to be seen. Also this is the reason performance testing has not yet been added to documentation, as it would be quite useless while refactoring the heuristic.

Next week
---------
* Finish documentation.
* Finish testing.
* Add a compiled .jar to GitHub.
