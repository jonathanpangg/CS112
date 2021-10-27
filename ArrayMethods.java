import java.util.*;

/* 
 * Problem Set 2
 *
 * File: ArrayMethods.java
 *
 * Author: Christine Papadakis-Kanaris
 * Course: CS112, Boston University
 *
 * Name: Jonathan Pang
 * Purpose: Contains the methods for Problem 7
 */

public class ArrayMethods {
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static void swapAdjacent(int[] values) { // swaps adjacent values
        if (values == null) // throw exception
            throw new IllegalArgumentException("Array is null.");
        for (int i = 0; i < values.length - 1; i+=2) { // goes by 2 and swaps the index and index + 1
            int temp = values[i];
            values[i] = values[i+1];
            values[i+1] = temp;
        }
        // System.out.println(Arrays.toString(values));
    }

    public static int[] copyReplace(int[] values, int oldVal, int newVal) { // replaces oldVal occurrences with newVal
        if (values == null) // throw exception
            throw new IllegalArgumentException("Array is null.");
        for (int i = 0; i < values.length; i++) { // iterates through the array to find the oldVal and changes them to the newVal
            if (values[i] == oldVal) 
                values[i] = newVal;
        }
        return values;
    }

    public static int maxSorted(int[] values) { // finds the longest sorted array in the given array
        int max = 1;
        int count = 1;
        if (values == null) // throw exception 
            throw new IllegalArgumentException("Array is null.");
        for (int i = 0; i < values.length - 1; i++) { // iterate through the array
            if (values[i] <= values[i + 1]) { // if curr val is greater than next val, add to counter
                count++;
            }
            else { // else if max is greater than count, change max to count and make count back to 1
                if (max < count) {
                    max = count;
                }
                count = 1;
            }
        }
        return max;
    }

    public static int getIndexOfDay(String day) { // gets the index of the day based on the static array 
        int pos = -1; // set pos variable to one, so that if the given day doesn't exist, then it will just return 01
        if (day != null) {
            for (int i = 0; i < DAYS.length; i++) { // iterates throughout the array to find the day
                if (day.equals(DAYS[i])) {
                    pos = i;
                }
            }
        }
        return pos;
    }

    public static int[] reverseInterchange( int[] arr1, int [] arr2 ) { // creates a final array that is part of the first array in forward iteration and part of the second array in backward iteration
        if (arr1 == null || arr2 == null) // throws exception
            throw new IllegalArgumentException("Array is null.");

        int length = 0;
        int counter = 0;

        // finds which array is sorter to set the final array's length
        if (arr1.length < arr2.length) 
            length = arr1.length;
        else
            length = arr2.length;
            
        int [] interchange = new int [length * 2];

        for (int i = 0; i < interchange.length; i++) {
            // if i is even, it takes from arr1; else, takes from arr2
            // uses counter variable to count the index of arr1 and arr2 to prevent out of bounds error
            if (i % 2 == 0) {
                interchange[i] = arr1[counter]; 
            }
            else {
                interchange[i] = arr2[length - 1 - counter];
                counter++; // only increase after arr2 has been transferred to resulting array
            }
        }

        return interchange;
    }
}
