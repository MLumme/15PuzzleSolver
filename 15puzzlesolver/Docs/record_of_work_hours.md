Date    | Time | Task
---     | ---  | ---
23-24.7 | ~4   | Research on A*, and its use in solving 15- and n-puzzles.
25.7    | ~1   | Creation of github repo and Maven-project.
26.7    | ~3   | Work on documentation.
1.8     | 4    | Programming the class for storing gamestate and its methods for checking its solvability and producing the list of its possible successor states, plus assorted getters and utility methods, and most of currently needed Junit-tests.
2.8     | 7    | Continuing to work on PuzzleState to compute heuristics, expanded testing to cover it. Wrote first version of IDA*, functioning not certain, as tests are not yet ready. Wrote javadocs for both classes.
5.8     | 3    | Testing for IDA*, fixing its bugs
7.8     | 2    | Coding of Stack-class.
8.8     | 2    | Made Stacks internal array change its capacity when needed, tests for Stack, coded Pair-class.
9.8     | 3    | Expanded slightly line coverage for tests, this week's documentation, attempted to make Stack use generic types, rollback until array creation for generic bit clearer.
13.8    | 4   | Initial work on UI, added contains-method for Stack, equals-method for PuzzleState to enable contains to do its comparisons.
15.8    | 5   | Testing for new method, fixing associated bugs. Finally modified Stack to be generic, with method naming following Deques method naming, and added a method for getting an array out of the stack, enabled IDA* to use homecooked stack, updated its test similarly.
16.8    | 5   | Added a new class Solver between UI and IDAStar, converts IDAStars output to PuzzleState-array, planned to provide a selector for different solving algorithms. Continued work on UI, which provides finally running program which produces correct results according to testing, appearance not yet even remotely finalized. Updated documentation, added current Class-diagram.
21.8   | 6    | Added iterative deepening depth first search-based solver to compare performace to IDA*, as IDA* is related but has increased performance from branch pruning from the use of heuristic to guide the search. Some clean-up of ui, added a method to generate random puzzles. Tests for IDDFS, pretty much copies of IDA*:s, slight adjustment to returns needed.
22.8   | 3    | Testing and writing for peer code review.
23.8   | 3    | Added commentary on tests to hopefully clarify their purpose. Documentation.
27.8   | 4    | Fixed some of the noted UI-related issues in the peer review, added an secondary command line utilizing main-class for performance testing.
29.8   | 4    | Performance testing, attempting to figure out what is going on with IDDFS-algorithm as far as speed is concerned. Structural UML-ish diagram for documentation. Added missing tests for solver. Added more commentary, fixed more of checkstyles warnings.
30.8   | 5    | Changed the way heuristics are calculated in attempt to cut unnecessary waste of processing time, refactored how it is done several times, and apparently did exactly opposite than hoped to, causing the program to slow down quite a lot, stored attempt into experimental branch for now.
2.9    | 6    | Continued trying to figure out the reason for slowdown caused by heuristic change, accidentally stumbled on a missing subtraction in heuristic calculation which was the culprit, found during debugging modifications for batch testing utility when trying to find source of endless loops. Time includes aforementioned modifications.
3.9    | 3    | Performance testing of the algorithm, added to testing documentation. Cross-platform testing from Windows Netbeans to Linux Netbeans and mvn CLI, fixed multiple problems with pom.xml causing issues with Maven on CLI.
4.9    | 2    | Added explanation of program file structure to implementation documentation. Did some research on replacing Java.util.Random with something else.
5.9    | 6     | Replaced inbuilt Random with XORShift-RNG, added testing, most of time used to understand what Java.util.Random:s nextInt(n) does to cram the output into wanted interval. Added user manual, made updates to rest of the documentation.
6.9    | 3     | last additions to documentation, final tests to be absolutely certain everything works, including maven commands. Added release to GitHub.
Total  | 86
