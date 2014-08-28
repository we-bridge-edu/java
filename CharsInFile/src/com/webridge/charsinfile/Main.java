package com.webridge.charsinfile;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input the path for the file to analyze:");
        String filePath = scan.nextLine();

        try {
            // Get the character count
            HashMap<Character, Integer> charCount = countChars(filePath);
            // Print the result
            displayCharCount(charCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays an ordered list of characters with their Unicode value and total count associated
     *
     * @param charCount The Map of character count (where the key is the character and the value is the character count)
     */
    public static void displayCharCount(HashMap<Character, Integer> charCount) {

        // Get the keys as an array of chars
        Character[] keys = charCount.keySet().toArray(new Character[0]);
        // Sort the keys
        Arrays.sort(keys);

        // Print all the required info for each key (i.e char found)
        for (char key : keys) {
            System.out.println(key + "(Unicode: " + Integer.toString(key) + "): " + charCount.get(key));
        }
    }

    /**
     * Counts each characters in the file at the specified location
     *
     * @param filePath The file to be analyzed
     * @return An HashMap with the Characters found as key and the count as value
     */
    public static HashMap<Character, Integer> countChars(String filePath)
            throws IOException {
        // Create the HashMap to register the char count
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        // Open an input stream
        // The buffered reader allows us to read text easily
        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath)));

        String line;
        // Read the file line by line to the end
        while ((line = input.readLine()) != null) {
            // Analyze each character of the line
            for (char c : line.toCharArray()) {
                // If it's a new character we create a new entry
                if (!count.containsKey(c))
                    count.put(c, 1);
                    // else we increment the count of this char
                else
                    count.put(c, count.get(c) + 1);
            }
        }

        return count;
    }
}
