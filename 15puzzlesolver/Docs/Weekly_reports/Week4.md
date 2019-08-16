Week 4 report
=============

Work done
---------

* Made the GUI usable (barely), currently should cath most incorrect inputs, except puzzlegrid does not yet catch attempts to input nonnumeric inputs.
* Modified Stack to be generic, not becous it needs to be but to make reusable, if needed.
* Added contains-method for stack to be used in IDA*, added equals-method for PuzzleState for Stack to use. Also added a toArray-method for stack which outputs stacs contents in Object-array, mimicing Deque.
* Updated testing for Stack and PuzzleState to account for new methods.
* Finally made IDAStar use Stack-class, replacing Deque, updated testing likewise.
* Added a new class between UI and IDAStar, Solver, which is responsible for converting IDAStars output PuzzleState-array, not that it matters that much, being simply tidier this way, and more importantly, will delegate solution for correct algorithm once I get arround implementing a second one (probably BFS or some other fairly simple).
* Updated documentation, obviously, but due to time constraints design- and testing documentation is not yet started properly.
* Updated JavaDoc-commentary, fixed Checkstyle-warnings, reconfigured Checkstyle to have longer method lengths and stop deeming nested blocks in switches as errors.

Next week
---------

* Construct second algorithm, compare its performance to IDA*.
* Finish testing the rest of classes, exludin main and ui.
* Start making testing- and design-documentation, add user manual.
* Make UI less of an eyesore, add functionality to reset program without shutting it down. Add more exception-handling to handle user errors.
