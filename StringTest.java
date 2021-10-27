/* 
 * Lab 2
 *
 * File: StringTest.java
 *
 * Author: Christine Papadakis-Kanaris
 * Coutse: CS112, Boston University
 *
 *
 * Purpose: This is a sample program performing basic input and
 * output in Java - specifically showing the use of the
 * hasNextLine method of the Scanner class. 
 */

import java.util.Scanner;

public class StringTest {

  public static void main(String[] args) {

     inputString();

  } // main()

  public static void inputString() {

    // Print out welcome message

    System.out.println("\nWelcome to the String Test Program!");

    // Declare a scanner object for user input

    Scanner userInput = new Scanner(System.in);

    System.out.print("\nType in a line of text (a String) or \"quit\" to end: ");

    // Continue to receive user input until some
    // sentinal (i.e. final) value is entered.
    // In this case, the user must enter the
    // word "quit".
    while (userInput.hasNextLine()) {
      String line = userInput.nextLine();
      if (line.equals("quit"))
	// User has specified input it over,
	// break out of the loop.
        break;
      else {
        System.out.println("You input: " + line);
        System.out.print("\nType in a line of text (a String) or \"quit\" to end: ");
      }
    } // while

    System.out.println("bye!");
    userInput.close();
  } // inputString()

} // class