package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class GameFX extends Application {
    private Cell[][] grid;
    private GameCell gameCell;
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        gameCell = new GameCell();
        grid = gameCell.grid;
        updateScene(grid, root);
        Scene scene = new Scene(root, 800 ,1000);

        javafx.scene.control.Button btn = new Button();
        btn.setText("100 iterations");
        btn.setOnAction((ActionEvent event) -> {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(300),
                    ae -> evolve(gameCell, root)));
            timeline.setCycleCount(100);
            timeline.play();

        });

        root.getChildren().add(btn);
        btn.setLayoutX(btn.getWidth() + (scene.getWidth()/2));
        btn.setLayoutY(900);

        stage.setScene(scene);
        stage.show();
    }

    public void evolve(GameCell gameCell, Pane root) {
        grid = gameCell.grid;
        gameCell.update();
        updateScene(grid, root);

    }

    public void updateScene(Cell[][] grid, Pane root) {
        root.getChildren().removeAll();
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid.length; j++) {
                int resolution = 20;
                int x = i* resolution;
                int y = j* resolution;
                javafx.scene.shape.Rectangle rectangle = new Rectangle(x, y, resolution, resolution);
                if (grid[i][j].getAlive()) {
                    rectangle.setFill(Color.BLACK);
                } else {
                    rectangle.setFill(Color.WHITE);
                }
                root.getChildren().add(rectangle);
            }
            
        }
    }
}
