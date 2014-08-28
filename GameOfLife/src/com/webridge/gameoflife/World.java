package com.webridge.gameoflife;

import java.util.Random;

/**
 * Created by Thomas on 8/27/2014.
 */
public class World {

    public static final String NEW_LINE = "\n";
    private Cell[][] world;
    private int currentGeneration;
    private int nbColumns, nbRows;

    /**
     * Generates a random new world of the specified size
     * @param nbColumns The number of columns (width) of the world
     * @param nbRows The number of columns (height) of the world
     */
    public World(int nbColumns, int nbRows){
        this.currentGeneration = 1;
        this.nbColumns = nbColumns;
        this.nbRows = nbRows;
        this.world = new Cell[nbRows][nbColumns];

        Random rdm = new Random();
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbColumns; j++) {
                world[i][j] = rdm.nextBoolean() ? new DeadCell() : new AliveCell();
            }
        }
    }

    public World(Cell[][] world){
        this.world = world;
        nbRows = world.length;
        nbColumns = world[0].length;
    }

    public void newGeneration(){
        Cell[][] next = new Cell[nbRows][nbColumns];
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbColumns; j++) {
                next[i][j] = world[i][j].newGeneration(
                        getAliveNeighborsCount(i, j)
                );
            }
        }
        world = next;
        currentGeneration++;
    }

    public int getAliveNeighborsCount(int column, int row){
        int aliveNeighbors = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {

                if(i < 0 || i >= nbRows
                        || j < 0 || j >= nbColumns
                        || (i == column && j == row))
                    continue;

                if(world[i][j].isAlive())
                    aliveNeighbors++;
            }
        }

        return aliveNeighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Generation " + currentGeneration + ":")
                .append(NEW_LINE);

        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbColumns; j++) {
                sb.append(world[i][j].getAsString());

                if(j < nbColumns - 1)
                    sb.append(" ");
            }
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }
}
