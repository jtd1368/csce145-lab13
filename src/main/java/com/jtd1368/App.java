package com.jtd1368;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Puzzle puzzle;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Parent root = fxmlLoader.load();
        PrimaryController controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 640, 480);
        
        puzzle = new Puzzle();
        
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
            case W:
                puzzle.moveUp();
                break;
            case A:
                puzzle.moveLeft();
                break;
            case S:
                puzzle.moveDown();
                break;
            case D:
                puzzle.moveRight();
                break;
            default:
                break;
            }

            controller.redrawPuzzle();
        });

        stage.setScene(scene);
        stage.show();
    }

    static Puzzle getPuzzle() {
        return puzzle;
    }

    public static void main(String[] args) {
        launch();
    }

}