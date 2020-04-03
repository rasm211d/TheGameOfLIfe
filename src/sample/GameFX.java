package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameFX extends Application {
    private Cell[][] grid;
    private GameCell gameCell;
    @Override
    public void start(Stage stage) /*throws Exception*/ {
        Pane root = new Pane();
        gameCell = new GameCell();
        grid = gameCell.grid;
        updateScene(grid, root);
        Scene scene = new Scene(root, 800 ,1000);

        javafx.scene.control.Button btn = new Button();
        btn.setText("150 iterations");
        btn.setOnAction((ActionEvent event) -> {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(500),
                    ae -> evolve(gameCell, root)));
            timeline.setCycleCount(150);
            timeline.play();

        });

        btn.setPrefWidth(200);
        btn.setLayoutY(900);
        btn.setLayoutX(300);

        root.getChildren().add(btn);


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
                javafx.scene.shape.Circle circle = new Circle(x + 1, y + 1, 9);
                if (grid[i][j].getAlive()) {
                    circle.setFill(Color.BLACK);
                } else {
                    circle.setStroke(Color.WHITE);
                    circle.setFill(Color.WHITE);

                }
                root.getChildren().add(circle);
            }
            
        }
    }
}
