/* 
 * Problem Set 2
 *
 * File: MyMethods.java
 *
 * Author: Christine Papadakis-Kanaris
 * Course: CS112, Boston University
 *
 * Name: Jonathan Pang
 * Purpose: Contains the methods for Problem 5
 */

public class MyMethods {
    public static void printDecreasing(String str) { // prints the given string in decreasing order in terms of its characters
        for (int i = str.length(); i > 0; i--) { // starts at the string itself and keeps decreasing until it reachs to the first character of the string
            System.out.println(str.substring(0, i));
        }
    }

    public static String firstAndLast(String str) { // returns the first and last character of the given string
        if (str.length() == 1) // returns the same string if the length of the string is one character
            return str;
        return (str.charAt(0) + "" + str.charAt(str.length() - 1)); // returns the first character and the last character and concatenates them into a string
    }

    public static int lastIndexOf(String str, char ch) { // returns the last index of the selected characters of the given string 
        int index = -1; // set the index as -1, so that if the character never occurs in the string then, it will return just -1
        
        for (int i = 0; i < str.length(); i++) { // iterates through the whole string and saves the index of the selected character each time it occurs
            if ((str.charAt(i) + "").equals(ch + "")) {
                index = i;
            }
        }

        return index;
    }

    public static String repeat(String str, int n) { // returns a string that is repeated by n amount of times
        String s = ""; // an empty string to add the given string to

        for (int i = 0; i < n; i++) { // adds the given string to the empty string n times
            s += str;
        }

        return s;
    }
}