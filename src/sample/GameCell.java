package sample;

import java.util.ArrayList;
import java.util.List;

public class GameCell {
    public int columns;
    public int rows;
    public int resolution = 20;
    public Cell[][] grid = new Cell[20][20];
    public Game game;
    public int iteration;

    public GameCell() {
        make2dArray(columns, rows);
    }

    public static Game initialize() {
        Game game = new Game();
        return game;
    }

    public void make2dArray(int columns, int rows) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int k = (int)Math.round(Math.random());
                Cell cell = new Cell();
                cell.setName("X: " + columns + " Y: " + rows);
                System.out.println(cell.getName());
                if (k == 1) {
                    cell.setAlive(true);
                } else {
                    cell.setAlive(false);
                }
                grid[i][j] = cell;
            }

        }
    }
    //TODO fiks update metode. listen skal tjekke alle hjørner. det gør den ikke...

    public Game update() {
        iteration++;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                 //List neighborsList = new ArrayList();
                //int neighbors = countNeighbors(grid, i, j);
                //neighborsList.add(neighbors);

            }
        }
        return game;
    }

    private int countNeighbors(Cell[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (grid[x+i][y+j].getAlive()) {
                    sum += 1;
                }
            }
        }
        sum = sum-1;
        return sum;
    }
}
