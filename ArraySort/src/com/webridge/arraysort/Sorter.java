package com.webridge.arraysort;

import java.util.Random;

/**
 * Created by Thomas on 8/27/2014.
 */
public class Sorter {

    public static void main(String[] args) {
        // Initializing an array of size 10
        // You can change this value to try bigger arrays!
        int[] values = new int[10];

        // Creating a random number generator
        Random rdm = new Random();

        // Initializing array with random values between 0 and 100
        for (int i = 0; i < values.length; i++) {
            values[i] = rdm.nextInt(100);
        }

        System.out.println("Original values");
        displayArray(values);

        System.out.println("BubbleSort values");
        displayArray(bubbleSort(values.clone()));

        System.out.println("SelectionSort values");
        displayArray(selectionSort(values.clone()));

        System.out.println("InsertionSort values");
        displayArray(insertionSort(values.clone()));
    }

    /**
     * Bubble sort an array of integers
     *
     * @param array Array of int to bubble-sort
     * @return Bubble-sorted array
     */
    public static int[] bubbleSort(int[] array) {
        boolean swapped;

        int length = array.length;
        do {
            swapped = false;
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;

                    swapped = true;
                }
            }
            length--;
        } while (swapped);

        return array;
    }

    /**
     * Selection sort an array of integers
     *
     * @param array Array of int to Selection-sort
     * @return Selection-sorted array
     */
    public static int[] selectionSort(int[] array) {
        int i, j;
        int iMin;

        for (j = 0; j < array.length; j++) {

            // Assume the min is the first element
            iMin = j;

            // test against elements after j to find the smallest
            for (i = j + 1; i < array.length; i++) {
                // If this element is less, then it is the new minimum
                if (array[i] < array[iMin]) {
                    // Found new minimum; remember its index
                    iMin = i;
                }
            }

            if (iMin != j) {
                int tmp = array[j];
                array[j] = array[iMin];
                array[iMin] = tmp;
            }

        }
        return array;
    }

    /**
     * Insertion sort an array of integers
     *
     * @param array Array of int to Insertion-sort
     * @return Insertion-sorted array
     */
    public static int[] insertionSort(int[] array) {

        int j, newValue;

        for (int i = 1; i < array.length; i++) {
            newValue = array[i];
            j = i;
            while (j > 0 && array[j - 1] > newValue) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = newValue;
        }

        return array;
    }

    /**
     * Prints all the values in the array with the format:
     * [value1, value2, value3...]
     *
     * @param array
     */
    public static void displayArray(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }

}
