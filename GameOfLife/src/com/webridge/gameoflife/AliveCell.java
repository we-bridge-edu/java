package com.webridge.gameoflife;

/**
 * Created by Thomas on 8/27/2014.
 */
public class AliveCell extends Cell {

    @Override
    Cell newGeneration(int nbNeighbours) {
        if(nbNeighbours < 2 || nbNeighbours > 3)
            return new DeadCell();

        return this;
    }

    @Override
    String getAsString() {
        return "+";
    }

    @Override
    boolean isAlive() {
        return true;
    }
}
