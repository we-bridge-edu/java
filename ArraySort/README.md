Sorting exercise
====

The goal of this exercise is to implement in java the common types of sort algorithm.
You can find information on such algorithm easily online (e.g Wikipedia)

The rules
===

You need to be able to sort an **array of integers** (i.e `int[]`) using the following algorithms:

* Bubble sort
* Selection sort
* Insertion sort

Getting started
===

1. Create a project named `ArraySort`
2. Create a package `com.webridge.arraysort`
3. Create a class `Sorter` with:
    * The **Main** method to test your sorts
        * You can initialize the array with random values with the **Random** class available in `java.util.Random`
        See the **JavaDoc** for more information about the Random class.
    * A method `public static void displayArray(int[] array)`
        * Displays the values in a array in the format `[2, 5, 1, 8]`
    * A method `public static int[] bubbleSort(int[] array)`
    * A method `public static int[] selectionSort(int[] array)`
    * A method `public static int[] insertionSort(int[] array)`