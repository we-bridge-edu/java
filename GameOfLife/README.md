The "Game Of Life" Exercise
====

The rules
===

 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 2. Any live cell with two or three live neighbours lives on to the next generation.
 3. Any live cell with more than three live neighbours dies, as if by overcrowding.
 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

How to begin
===

1. Create a new project named `GameOfLife`
2. Create a package `com.webridge.gameoflife`
3. Create an abstract class `Cell` with the following abstract methods:
    * `abstract Cell newGeneration(int nbNeighbors)`
        * Returns an **Alive Cell** or a **Dead Cell** depending on the given number of neighbors
    * `abstract String getAsString()`
        * Returns a string representation of the **Cell** (e.g `+` for alive, `-` for dead)
    * `abstract boolean isAlive()`
        * Returns true if the **Cell** is alive, false if the **Cell** is dead
4. Create the `AliveCell` and `DeadCell` classes that **inherits** from the **Cell** class
5. Create a class `World` with the following:
    * A **constructor** taking a **number of rows** and a **number of columns** as parameters
    * A **constructor** taking an two-dimensional array of cell (i.e `Cell[][]`)
    representing an existing **World** as parameter
    * A public method `public void newGeneration()`
        * Changes the current world to its next generation
    * A public method `public int getAliveNeighbors(int column, int row)`
        * Calculates the number of **Alive Cell** around the cell at the given position
    * The `ToString()` method (`@Override`) that returns a string representing
    the current world and the generation number
6. Create a `Launcher` class with the **Main** method to test your game! 

**Note**: *Those are general directions so you might need to add more methods or fields to complete the exercise.
Also other solutions are possible, you are free to try your own implementation if you see it as more optimized*.
