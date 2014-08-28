package com.webridge.gameoflife;

/**
 * Created by Thomas on 8/27/2014.
 */
public class DeadCell extends Cell {
    @Override
    Cell newGeneration(int nbNeighbours) {
        if(nbNeighbours == 3)
            return new AliveCell();

        return this;
    }

    @Override
    String getAsString() {
        return "-";
    }

    @Override
    boolean isAlive() {
        return false;
    }
}
