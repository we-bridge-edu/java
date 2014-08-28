package com.webridge.fizzbuzz;

public class Main {

    public static void main(String[] args) {
        // For all numbers from 1 to 99
        // If you want to include 100 use "<="
        for (int i = 1; i < 100; i++) {

            // If multiple of 3 and 5 print fizzbuzz
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("fizzbuzz");
            }

            // If multiple of 3 (and not 5) print fizz
            else if (i % 3 == 0) {
                System.out.print("fizz");
            }

            // If multiple of 5 (and not 3) print buzz
            else if (i % 5 == 0) {
                System.out.print("buzz");
            }
            // else print the number
            else {
                System.out.print(i);
            }

            // Inserting a line break after 9, 19, 29...
            // Multiple solutions, here we check if the value + 1
            // is a multiple of 10: (9+1, 19+1, 29+1)
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
            // Put a space between other numbers
            else{
                System.out.print(" ");
            }
        }
    }
}
