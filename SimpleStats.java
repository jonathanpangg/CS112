/*
 * Problem Set 1
 * 
 * A simple interactive program that performs operations 
 * on a set of three integers.
 *
 * CS112
 *
 */

import java.util.*;

/*
 * Program Class Defintion
 */
public class SimpleStats {

    /*
     * printMenu()정말
     *
     * Method to display user options.
     */
    public static void printMenu() {
        System.out.println("(0) Enter new numbers");
        System.out.println("(1) Find the largest");
        System.out.println("(2) Compute the sum");
        System.out.println("(3) Compute the range (largest - smallest)");
        System.out.println("(4) Compute the average");
        System.out.println("(5) Print the numbers in ascending order");
        System.out.println("(6) Quit");
        System.out.println();
    }
    
    /*** PUT YOUR SEPARATE METHODS FOR OPTIONS 1-5 HERE ***/
    
    public static int max(int a, int b, int c) { // finds the max number 
        if (a >= b && a >= c) { // a > b; a > c
            return a;
        }

        else if (a >= b && a <= c) { // c > a > b
            return c;
        }

        else if (a >= c && a <= b) { // b > a > c
            return b;
        }

        else if (b >= a && b >= c) { // b > a; b > c
            return b;
        }

        else if (b >= a && b <= c) { // c > b > a
            return c;
        }

        else if (b >= c && b <= a) { // a > b > c
            return a;
        }

        else if (c >= a && c >= b) { // c > a; c > b
            return c;
        }

        else if (c >= a && c <= b) { // b > c > a
            return b;
        }

        else { // a > c > b
            return a;
        }
    }
    
    public static int sum(int a, int b, int c) { // finds the sum 
        return a + b + c;
    }

    public static int range(int a, int b, int c) { // finds the range 
        int max = max(a, b, c);
        return  max - min(a, b, c, max);
    }

    // helper func for finding range and ascending order 
    public static int min(int a, int b, int c, int max) {
        if (max == a) { // det b and c
            if (b >= c) 
                return c;
            else 
                return b;
        }
        else if (max == b) { // det a and c
            if (a >= c)
                return c;
            else 
                return a;
        }
        else { // det a and b
            if (a >= b)
                return b;
            else 
                return a;
        }
    }
    
    public static double average(int a, int b, int c) { // finds the mean
        return ((double)a + b + c) / 3;
    }

    public static void ascending(int a, int b, int c) { // prints in ascending order
        int max = max(a, b, c);
        int min = min(a, b, c, max);
        int middle = 0;
    
        if (!(min == a || max == a)) { 
            middle = a;
        }
        
        else if (!(min == b || max == b)) {
            middle = b;
        }

        else {
            middle = c;
        }

        System.out.println("The numbers in ascending order is " + min + " " + middle + " " + max);
    }
    /*
     * main()
     *
     * Program execution begins with this method.
     */
    public static void main(String[] args) {
        // Create an instance of a scanner object and
	// connect to the standard input device
        Scanner scan = new Scanner(System.in);
        // variable declarations and initializations as needed
        boolean more_input = true;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        boolean ok = false;
	/* 
 	 * Control loop
 	 */
        do {
            int choice = -1;
            // If numbers have been entered (choice 0) has been selected, output the numbers
            // Call the method which displays the menu choices
            printMenu();
	        // Prompt to enter the choice of operation
            if (choice != 0) {
                System.out.print("Enter a choice: ");
                choice = scan.nextInt();
            }
            /*
             * Expand this conditional statement to correctly process all choices.
             * Make sure to follow the guidelines in the assignment for
             * doing so.
             */
            if (choice == 0) {
                ok = true;
                System.out.print("Enter three new numbers: ");
                n1 = scan.nextInt();
                n2 = scan.nextInt();
                n3 = scan.nextInt();
                System.out.println("n1 = " + n1 + "\nn2 = " + n2 + "\nn3 = " + n3);
                // Input the three numbers
                // Verify the numbers entered by printing them out
            } 
            
            if (ok) {
                if (choice == 1) {
                    System.out.println("Max number is " + max(n1, n2, n3) + ".");
                }
                else if (choice == 0);
                
                else if (choice == 2 ) {
                    System.out.println("The sum is " + sum(n1, n2, n3) + ".");
                }

                else if (choice == 3) {
                    System.out.println("The range is " + range(n1, n2, n3) + ".");
                }

                else if (choice == 4) {
                    System.out.println("The average is " + average(n1, n2, n3) + ".");
                }

                else if (choice == 5) {
                    ascending(n1, n2, n3);
                }

                else if (choice == 6) {
                    more_input = false;
                } 
                else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            else {
                if (choice >= 0 && choice < 7) {
                    System.out.println("Cannot compute, numbers have not been entered");
                }
                else {
                    System.out.println("Invalid choice. Please try again.");
                }
                if (choice == 6) {
                    more_input = false;
                } 
            }

            System.out.println();
        } while (more_input);
        scan.close();
        System.out.println("Have a nice day!");
    }
}