
package com.mycompany.ui;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {
    int size;
    Parent root;
    Alert dialogue;
    int[] puzzle;
    
    @Override
    public void start(Stage stage) {
        dialogue = new Alert(Alert.AlertType.ERROR);
        
        constructPuzzle();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private void constructSize() {
        VBox vb = new VBox();
        
        Label label = new Label("Edge length of puzzle?");
        TextField sizeField = new TextField();
        Button button = new Button("Submit");
        
        button.setOnAction((event) -> {
            int tempSize = 0;
            try {
                tempSize = Integer.parseInt(sizeField.getText());
                
                if (tempSize <= 0) {
                    dialogue.setContentText("Edge length can't be less or equal to zero");
                    dialogue.show();
                } else {
                    size = tempSize;
                    System.out.println(size);
                    constructPuzzle();
                }  
            } catch (NumberFormatException ex) {
                dialogue.setContentText("Unable to parse input as integer");
                dialogue.show();
            }  
        });
        
        vb.getChildren().add(label);
        vb.getChildren().add(sizeField);
        vb.getChildren().add(button);
        
        root = vb;
    }
    
    private void constructPuzzle() {
        size = 3;
        
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
            
            System.out.println(Arrays.toString(puzzle));
        });
        
        root = vb;
    }
}
