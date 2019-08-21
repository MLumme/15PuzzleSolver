Date    | Time | Task
---     | ---  | ---
23-24.7 | ~4   | Research on A*, and its use in solving 15- and n-puzzles.
25.7    | ~1   | Creation of github repo and Maven-project.
26.7    | ~3   | Work on documentation.
1.8     | 4    | Programming the class for storing gamestate and its methods for checking its solvabilty and producing the list of its possible successor states, plus assorted getters and utility methods, and most of currently needed Junit-tests.
2.8     | 7    | Continuing to work on PuzzleState to compute heuristics, expanded testing to cover it. Wrote first version of IDA*, functioning not certain, as test ar not yet ready. Wrote javadocs for both classes.
5.8     | 3    | Testing for IDA*, fixing its bugs
7.8     | 2    | Coding of Stack-class.
8.8     | 2    | Made Stacks internal array change its capacity when needed, tests for Stack, coded Pair-class.
9.8     | 3    | Expanded slightly line coverage for tests, this weeks documetation, attemted to make Stack use generic types, rollback until array creation for generic bit more clear.
13.8    | 4    | Inital work on UI, added contains-method for Stack, equals-method for PuzzleState to enable contains to do its comparisons.
15.8    | 5   | Testing for new method, fixing associated bugs. Finally modified Stack to be generic, with method naming following Deques method naming, and added a method for getting an array out of the stack, enabled IDA* to use homecooked stack, updated its test similarly.
16.8    | 5   | Added a new class Solver between UI and IDAStar, converts IDAStars output to PuzzleState-array, planned to provide a selector for different solving algorithms. Contiunued work on UI, which provides finally running program which produces correct results according to testing, appearance not yet even remotely finalized. Updated documentation, added current Class-diagram.
21.8   | 6    | Added iterative deepening depth first search based solver to compare performase to IDA*, as IDA* is related but has increased performance from branch pruning from the use of heuristic to guide the search. Some cleanup of ui, added a method to generate random puzzles. Tests for IDDFS, pretty much copies of IDA*:s, slight adjustment to returns neded.
Total  | 47
