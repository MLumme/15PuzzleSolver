
package com.mycompany.ui;

import com.mycompany.domain.PuzzleState;
import com.mycompany.domain.Solver;
import com.mycompany.structs.Pair;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.mycompany.util.PuzzleGen;

/**
 *Class for operating JavaFX-based GUI
 */
public class UI extends Application {
    int size;
    Pair<Long, PuzzleState[]> solution;
    Stage mainStage;
    Alert dialogue;
    int[] puzzle;
    
    @Override
    public void start(Stage stage) {
        mainStage = stage;
        mainStage.setMinHeight(100);
        mainStage.setMinWidth(200);
        
        dialogue = new Alert(Alert.AlertType.ERROR);
        
        constructSizeScene();
        
        stage.show();
    }
    
    /**
     * constructs the scene for requesting size of the puzzle
     */
    private void constructSizeScene() {
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setFillWidth(false);
        vb.setSpacing(5);
        
        Label label = new Label("Edge length of puzzle?");
        
        TextField sizeField = new TextField();
        
        Button button = new Button("Submit");
        
        button.setOnAction((event) -> {
            int tempSize = 0;
            try {
                tempSize = Integer.parseInt(sizeField.getText());
                
                if (tempSize <= 1) {
                    dialogue.setContentText("Edge length can't be less or equal to 1");
                    dialogue.show();
                } else if (tempSize > 10) {
                    dialogue.setContentText("Edge length limited to under 10 for usability reasons");
                    dialogue.show();
                } else {
                    size = tempSize;
                    constructPuzzleScene();
                }  
            } catch (NumberFormatException ex) {
                dialogue.setContentText("Unable to parse input as integer");
                dialogue.show();
            }  
        });
        
        vb.getChildren().add(label);
        vb.getChildren().add(sizeField);
        vb.getChildren().add(button);
        
        Scene scene = new Scene(vb);
        
        mainStage.setScene(scene);
    }
    
    /**
     * constructs scene for inputing the puzzle into an sizeXsize grid
     */
    private void constructPuzzleScene() {        
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setFillWidth(false);
        vb.setSpacing(5);
        
        GridPane gp = new GridPane();
        
        TextField[][] puzzleArray = new TextField[size][size];
        
        HBox selectorbox = new HBox();
        ToggleGroup selector = new ToggleGroup();
        RadioButton idastar = new RadioButton("IDA*");
        RadioButton iddfs = new RadioButton("IDDFS");
        
        idastar.setToggleGroup(selector);
        idastar.setSelected(true);
        iddfs.setToggleGroup(selector);
        selectorbox.getChildren().add(idastar);
        selectorbox.getChildren().add(iddfs);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TextField tf = new TextField();
                tf.setMaxWidth(50);
                
                gp.add(tf, i, j);
                
                puzzleArray[i][j] = tf;
            }
        }

        Button genRandom = new Button("Generate random puzzle");
        genRandom.setOnAction((event) -> {
            puzzle = PuzzleGen.generate(size * size, size * size).getBoard();
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    puzzleArray[i][j].setText(Integer.toString(puzzle[i + j * size]));
                }
            }
        });
        
        Button submit = new Button("Submit");       
        submit.setOnAction((event) -> {
            puzzle = new int[size * size];
            
            try {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        dialogue.setContentText("Unable to parse input as integer,"
                                + " first error at row " + (i + 1) + ", col " + (j + 1));
                        puzzle[i * size + j] = Integer.parseInt(puzzleArray[j][i].getText());
                    }
                }

                PuzzleState initState = new PuzzleState(puzzle);

                if (!initState.isValid()) {
                    dialogue.setContentText("Given puzzle invalid, "
                            + "either incorrect or duplicate numbers present");
                    dialogue.show();
                } else if (!initState.isSolvable()) {
                    dialogue.setContentText("Given puzzle is unsolvable");
                    dialogue.show();
                } else if (initState.isFinal()) {
                    dialogue.setContentText("Given puzzle is already final state");
                    dialogue.show();
                } else {
                    int algo = 0;

                    if(idastar.isSelected()) {
                        algo = 1;
                    } else if (iddfs.isSelected()) {
                        algo = 2;
                    }
                    solution = Solver.solve(initState, algo);
                    constructSolutionScene();
                } 
            } catch (NumberFormatException ex) {
                dialogue.show();
            }
        });
        
        vb.getChildren().add(gp);
        vb.getChildren().add(genRandom);
        vb.getChildren().add(selectorbox);
        vb.getChildren().add(submit);

        
        Scene scene = new Scene(vb);

        mainStage.setScene(scene);        
    }
    
    /**
     * Constructs scene for showing some statistics for solution and moves needed
     * to solve the puzzle.
     */
    private void constructSolutionScene() {
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setFillWidth(false);
        vb.setSpacing(5);
        
        TextArea text = new TextArea();
        
        text.appendText("Initial estimate number of steps: " + solution.getValue()[0].getManhattanHeuristic() + "\n");
        text.appendText("Actual number of steps: " + (solution.getValue().length - 1) + "\n");
        text.appendText("Time elapsed in ms: " + solution.getKey() + "\n");
        text.appendText("\n");
        text.appendText("Steps to solution: \n");
        for (int i = 0; i < solution.getValue().length - 1; i++) {
            text.appendText("Move empty ");
            
            int move = solution.getValue()[i + 1].getEmpty() - solution.getValue()[i].getEmpty();
            
            if(move == -1) {
                text.appendText("left\n");
            } else if (move == 1) {
                text.appendText("right\n");
            } else if (move < -1) {
                text.appendText("up\n");
            } else {
                text.appendText("down\n");
            }           
        }
        
        Button reset = new Button("Reset");
        reset.setOnAction((event) -> {
            constructSizeScene();
        });
        
        vb.getChildren().add(text);
        vb.getChildren().add(reset);
        
        Scene scene = new Scene(vb);
        
        mainStage.setScene(scene);
    }
}
