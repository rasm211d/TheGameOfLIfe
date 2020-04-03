package sample;

public class GameCell {
    public int columns = 40;
    public int rows = 40;
    public Cell[][] grid;
    public int iteration;

    public GameCell() {
        grid = new Cell[columns][rows];
        iteration = 0;
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                int k = (int)Math.round(Math.random());
                Cell cell = new Cell();
                cell.setName("X: " + this.columns + " Y: " + this.rows);
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


    public void update() {
        iteration++;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == 0 ||  i == columns -1 || j == 0 || j == rows -1) {
                    grid[i][j].setLivingNeighbours(grid[i][j].getLivingNeighbours());
                } else {
                    grid[i][j].setLivingNeighbours(countNeighbors(grid, i, j));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j].update();
            }
        }

    }

    public int countNeighbors(Cell[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (grid[x+i][y+j].getAlive()) {
                    sum += 1;
                }
            }
        }
        if (grid[x][y].getAlive()) {
            sum = sum - 1;
        }
        return sum;

    }
}
