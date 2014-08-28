package com.webridge.gameoflife;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        World world = new World(1, 10);

        System.out.println(world);

        for (int i = 0; i < 100; i++) {
            // Wait for 2 seconds between each gen
            // to better see the changes
            Thread.sleep(2000);

            world.newGeneration();
            System.out.println(world);
        }
    }
}
