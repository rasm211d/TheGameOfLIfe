package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {
    public int columns;
    public int rows;
    public int resolution = 20;
    public int[][] grid;
    public Cell[][] cellGrid;


    @Override
    public void start(Stage stage) throws Exception {
        columns = 1000;
        rows = 1000;
        grid = make2dArray(columns, rows);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = (int) Math.round(Math.random());
            }
        }

        Pane root = new Pane();
        drawGrid(grid, root);
        Scene scene = new Scene(root, 1000,1000);
        stage.setScene(scene);


        stage.show();

    }


    public int[][] make2dArray(int columns, int rows) {
        int[][] array = new int[columns][rows];
        return array;
    }

    public void drawGrid(int[][] grid, Pane root) {
        root.getChildren().removeAll();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int x = i*resolution;
                int y = j*resolution;
                Rectangle rectangle = new Rectangle(x, y, resolution, resolution);
                if (grid[i][j] == 1) {
                    rectangle.setFill(Color.BLACK);
                } else {
                    rectangle.setFill(Color.WHITE);
                }
                root.getChildren().add(rectangle);
            }
        }
    }



}
