/* Starter code */

import java.util.Scanner;

public class RecurPalindrome {

    public static void main(String[] args) {

	// Welcome message 
	System.out.println("\nWelcome to the Palindrome Test Program!");

	// Takes in one user input
	Scanner userInput = new Scanner(System.in);
	System.out.println("\nType in a word and press enter:");
	String word = userInput.nextLine();
	userInput.close();

	
	// Call the recursive function here!
	// ** Note: true is a space holder.   **
	// ** Remove it and insert your code! **
	
	boolean isPalindrome = true; 

        // YOUR CODE HERE

	
	// Printing out the result
	if (isPalindrome)
	    System.out.println("Palindrome!");
	else
	    System.out.println("Not a palindrome!");
    }


    
    private static boolean isPalindrome(String s) {
	
	// YOUR CODE HERE

	// Hints: you will need to construst the base cases
	// and make the appropriate recursive calls! 
        
    }
    
}
	