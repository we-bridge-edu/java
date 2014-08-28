package com.webridge.gameoflife;

/**
 * Created by Thomas on 8/27/2014.
 */
public abstract class Cell {
    abstract Cell newGeneration(int nbNeighbours);
    abstract String getAsString();
    abstract boolean isAlive();
}
