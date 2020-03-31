package sample;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int livingNeighbours;
    private boolean alive;
    private int iteration = 0;
    private List neighbourList;
    private String name;

    public Cell() {
        livingNeighbours = -1;
        iteration = 0;
        neighbourList = new ArrayList();
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

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int getIteration() {
        return iteration;
    }

    public void setNeighbourList(List neighbourList) {
        this.neighbourList = neighbourList;
    }

    public List getNeighbourList() {
        return neighbourList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
