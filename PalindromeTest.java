import java.util.*;

/* 
 * Problem Set 2
 *
 * File: PalindromeTest.java
 *
 * Author: Christine Papadakis-Kanaris
 * Course: CS112, Boston University
 *
 * Name: Jonathan Pang
 * Purpose: Contains the methods for Problem 6
 */

public class PalindromeTest { 
    public static boolean isPalindrome( String s ) {
        s = s.toLowerCase(); // brings every character into lowercase to compare them equally

        String nonLetters = ",!.\"\\:\'; /"; // a string of non-letters

        for (int i = 0; i < nonLetters.length(); i++) { // iterates through the string of non-letters
          for (int j = s.length() - 1; j >= 0; j--) { // iterates backwards through the string to accurately remove any non-letters within the given string 
            if ((s.charAt(j) + "").equals(nonLetters.charAt(i) + "")) { 
              if (j != s.length() - 1) // general case to remove a specific character from the string
                s = s.substring(0, j) + s.substring(j + 1);
              else // special case to remove the last index of the string 
                s = s.substring(0, j);
            }
          }
        }
        boolean isPal = false; // assume that it is not
      
        // code to determine if the string s is a palindrome
        // If the default (as above) assumes the string is not a palindrome,
        // the logic here should determine if it is and reassign the return
        // variable isPal appropriately, or vice verse.
        if (s.length() % 2 == 0) { // case when there is an even number of characters in the string 
          String str1 = "";
          String str2 = "";
          for (int i = 0; i < s.length() / 2; i++) { // takes first half of the string
              str1 += (s.charAt(i) + "");
          }
          for (int i = s.length() - 1; i >= s.length() / 2; i--) { // takes the second half of the string in reverse order 
              str2 += (s.charAt(i) + "");
          }
          // compares the two strings 
          if (str1.equals(str2)) 
            isPal = true;
          else
            isPal = false;
        }
        else { // case when there is an odd number of characters in the string 
          String str1 = "";
          String str2 = "";
          // same as the previous case except we ignore the middle character
          for (int i = 0; i < s.length() / 2; i++) { 
              str1 += (s.charAt(i) + "");
          }
          for (int i = s.length() - 1; i > s.length() / 2; i--) {
              str2 += (s.charAt(i) + "");
          }
          if (str1.equals(str2)) 
            isPal =  true;
           else
            isPal =  false;
        }

        return isPal;
    }
      
    public static int[] inputStringPalindrome() { // records the amount of palindromes and runs in the method
        int [] values = new int [2];
        boolean ok = true; // while this variable is true means the user doesn't want to quit
        Scanner scan = new Scanner(System.in);
        while (ok) {
            System.out.println("Enter a string or enter \"quit\" to exit.");
            String str = scan.nextLine();
            if (str.equals("quit")) {
                ok = false;
                break;
            }
            // runs through the previous methods to prove if it is a palindrome
            if (isPalindrome(str)) {
                ++values[1];
            }
            if (!str.equals("quit")) {
                ++values[0];
            }
        }
        scan.close();
        return values;
    }
}