
package com.mycompany.ui;

import com.mycompany.domain.PuzzleState;
import com.mycompany.domain.Solver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *Class for operating JavaFX-based GUI
 */
public class UI extends Application {
    int size;
    PuzzleState[] solution;
    Stage mainStage;
    Alert dialogue;
    int[] puzzle;
    
    @Override
    public void start(Stage stage) {
        mainStage = stage;
        
        dialogue = new Alert(Alert.AlertType.ERROR);
        
        constructSizeScene();
        
        stage.show();
    }
    
    /**
     * constructs the scene for requesting size of the puzzle
     */
    private void constructSizeScene() {
        VBox vb = new VBox();
        
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
        GridPane gp = new GridPane();
        TextField[][] puzzleArray = new TextField[size][size];
        Button submit = new Button("Submit");
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TextField tf = new TextField();
                
                gp.add(tf, i, j);
                
                puzzleArray[i][j] = tf;
            }
        }
        
        vb.getChildren().add(gp);
        vb.getChildren().add(submit);
        
        submit.setOnAction((event) -> {
            puzzle = new int[size * size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    puzzle[i + j * size] = Integer.parseInt(puzzleArray[i][j].getText());
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
                solution = Solver.solveIDAStar(initState);
                constructSolutionScene();
            }
        });
        
        Scene scene = new Scene(vb);

        mainStage.setScene(scene);        
    }
    
    /**
     * Constructs scene for showing some statistics for solution and moves needed
     * to solve the puzzle.
     */
    private void constructSolutionScene() {
        TextArea text = new TextArea();
        
        text.appendText("Initial estimate number of steps: " + solution[0].getManhattanHeuristic() + "\n");
        text.appendText("Actual number of steps: " + (solution.length - 1) + "\n");
        text.appendText("\n");
        text.appendText("Steps to solution: \n");
        for (int i = 0; i < solution.length - 1; i++) {
            text.appendText("Move empty ");
            
            int move = solution[i + 1].getEmpty() - solution[i].getEmpty();
            
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
        
        Scene scene = new Scene(text);
        
        mainStage.setScene(scene);
    }
}
