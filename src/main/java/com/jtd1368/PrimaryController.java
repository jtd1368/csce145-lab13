package com.jtd1368;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PrimaryController {

    @FXML
    private GridPane tileGrid;

    private Label[][] labels;

    @FXML
    public void initialize() {
        labels = new Label[Puzzle.SIZE][Puzzle.SIZE];

        for (int i = 0; i < Puzzle.SIZE; i++) {
            for (int j = 0; j < Puzzle.SIZE; j++) {
                Label label = new Label("0");
                labels[i][j] = label;
                
                tileGrid.add(label, j, i);

                GridPane.setHalignment(label, HPos.CENTER);
            }
        }

        redrawPuzzle();
    }

    void redrawPuzzle() {
        for (int i = 0; i < Puzzle.SIZE; i++) {
            for (int j = 0; j < Puzzle.SIZE; j++) {
                labels[i][j].setText("" + App.getPuzzle().getTiles()[i][j]);
            }
        }
    }

    @FXML
    void resetPuzzle(ActionEvent event) {
        App.getPuzzle().reset();
        redrawPuzzle();
    }

    @FXML
    void scramblePuzzle(ActionEvent event) {
        App.getPuzzle().scramble();
        redrawPuzzle();
    }
}
