CLI
===

Testing, test coverage, checkstyle
----------------------------------

Tests can be run with
```
mvn test
```

Test coverage can be tested using either pit or jacoco, jacoco with
```
mvn jacoco:report
```
with output going to folder ``target/site/jacoco/index.html``, while pit can be run with 
```
mvn org.pitest:pitest-maven:mutationCoverage
```
and output ``index.htlm`` within latest subfolder of folder ``target/pit-reports/``. Note that some of the mutation tests will tile out.

Checkstyle can be run with
```
mvn jxr:jxr checkstyle:checkstyle
```

and output being generated in ``target/site/checkstyle.html``.

JavaDoc
-------
JavaDoc can be created with
```
mvn jacoco:report
```
with report being generated in folder ``target/site/apidocs/index.html``.

Packaging & Running
-------------------

Packaging the program into a ```.jar`` by running
```
mvn package
```
with the resulting ``15puzzlesolver-1.0-SNAPSHOT.jar`` being in ``target/``-folder. Program can then be run with
```
java -jar 15puzzlesolver-1.0-SNAPSHOT.jar
```

Program usage
=============

When starting the program, the GUI first asks user to enter and submit the size of the puzzle, measured in the length of the edge of the game board, e.g. 15-puzzle has size 4, 8-puzzle 3, and so on. sizes are limited to greater than 1, and less than 8, due quickly increasing size of solution, and correspondingly the increase of solution time.

Next view is the puzzle input, where the user can either enter their own puzzle, or randomly generating a puzzle. Random generation attempts to change every tile in the puzzle. Additionally, user can select which algorithm is used for solution, although IDDFS is disabled for 24-puzzle and above, due to its slowness at usual solution depth in generated puzzles of these sizes.

After submitting the puzzle, eventually user will be redirected to solution view, which lists the initial estimate of solution derived from Manhattan heuristic, actual length of solution, time taken to solve the puzzle, and list of movements of the empty tile used to reach correct solution. Finally, user can use reset-button to return to the start of the program.
