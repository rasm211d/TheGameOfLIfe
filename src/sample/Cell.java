package sample;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int livingNeighbours;
    private boolean alive;
    private int iteration = 0;
    private String name;

    public Cell() {
        livingNeighbours = -1;
        iteration = 0;
    }

    public void update() {
        if (!alive && livingNeighbours == 3) {
            alive = true;
        } else if ((alive && livingNeighbours == 2) || (alive && livingNeighbours == 3)) {
            alive = true;
        } else {
            alive = false;
        }
        iteration++;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
