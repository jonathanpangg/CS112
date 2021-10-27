/* File: Histogram.java
 * Author: CS112 Instructor
 * 
 * Purpose: This is a potential solution to the
 * Histogram problem.
 * 
 * Jonathan Pang
 */

import java.util.*;

public class Histogram { 
    
    private static final int SENTINAL = -999;          // sentinal value to signal endo of input
    private static final int MAX_NUMBERS = 20;         // maximum number of numbers to input
    private static final double UPPER_BOUND = 100.0;   // largest numbers accepted as data
    private static final double LOWER_BOUND = 0.0;     // smallest numbers accepted as adata
    private static final int NUM_BINS = 10;            // number of bins in range [0..100]
    private static final int BIN_SIZE = 10;          // size of each bin
   
    /*
     * Method to show an example of using StringBuilder.
     *
     * You will also notice that this method is called from the 
     * main function. 
     *
     */
    public static String getHeaderAsString( String me ) {

	// Create an instance of the StringBuilder class
	// which allows us to create an object of 
	// a series of strings that can then be converted 
	// into one large string via the toString method.
	//
    	StringBuilder sb=new StringBuilder();

        sb.append( System.getProperty("line.separator") );
        sb.append( "Welcome to the Histogram Program " + me + "!" );
	    me = getFirstName(me);
        sb.append( System.getProperty("line.separator") );
        sb.append( System.getProperty("line.separator") );
        sb.append( "This program will print out a histogram of the numbers" );
        sb.append( System.getProperty("line.separator") );
        sb.append( "input by you " + getFirstName(me) + "." );
        sb.append( System.getProperty("line.separator") );
        sb.append( System.getProperty("line.separator") );
        sb.append( "Please enter up to " + MAX_NUMBERS + " doubles or " + SENTINAL + " to stop input!" );
        sb.append( System.getProperty("line.separator") );

        return sb.toString();
    }

    /* 
     * Method to return the first name of the user in case
     * the full name was entered. 
     */
    public static String getFirstName(String name ) {
        // Note that add the " " to string to be sure
        // there is something to split
	    return (name+" ").split(" ")[0]; 
    }

    /* 
     * local main test driver
     *
     */
    public static void main(String[] args) {  
	    // Connect to the keyboard as the input stream
        Scanner userInput = new Scanner( System.in );

        System.out.print( "And who am I working with today? " );
        String user = userInput.nextLine();

	    String heading = getHeaderAsString( user );

        // Print out welcome message
        System.out.println( heading ); 
        
        // Call the method which prompts the user
        // to input the numbers that will be used
        // to build the histogram.
        double[] numbers = inputNumbers( userInput );

        // Call the method to reate the array histogram
        int[] histogram = calculateHistogram( numbers );

        // Print the historgram
        System.out.println(toString( histogram ) );
        System.out.println(Arrays.toString(histogram));
    }

    // This method should create and return an array of integers
    // that represents the resulting histogram from the numbers
    // entered and passed to the method.
    //
    public static int [] calculateHistogram( double [] numbers ) {
        int [] array = new int [10];

        // adds a star for each interval in findBin
        for (int i = 0; i < numbers.length; i++) {
            ++array[findBin(numbers[i])];
        }

        return array;
    }

    // finds the location of the interval for the selected number
    public static int findBin( double num ) {
        
        // a loop with ranges with exception for the first index
        for (int i = 0; i < NUM_BINS; i++) {
            int a = i * 10;
            int b = (i + 1) * 10;
            if (i == 0) {
                if (a <= num && b >= num)
                    return 0;
            }
            else {
                if (a < num && b >= num)
                    return i;

            }
         }
         return 9;
    }

    // returns the string representation of the histogram
    public static String toString( int [] histogram ) {
        String str = "";
        String linebreak = "\n";

        for (int i = 0; i < histogram.length; i++) {
            switch (i + "") {
                case "0": 
                    str += "[0...10]:   ";
                    break;
                case "1":
                    str += "(10...20]:  ";
                    break;
                case "2":
                    str += "(20...30]:  ";
                    break;
                case "3":
                    str += "(30...40]:  ";
                    break;
                case "4":
                    str += "(40...50]:  ";
                    break;
                case "5":
                    str += "(50...60]:  ";
                    break;
                case "6":
                    str += "(60...70]:  ";
                    break;
                case "7":
                    str += "(70...80]:  ";
                    break;
                case "8":
                    str += "(80...90]:  ";
                    break;
                default:
                    str += "(90...100]: ";
                    break;
            }

            for (int j = 0; j < histogram[i]; j++) {
                str += "*";
            }
    
            str += linebreak;
        }
        // The histogram can be visualzed as a series of
        // buckets, where each bucket represents one range
        // of the histogram:
           
        // The string returned should only contain the string representation
        // of the histogram and no other verbeage. It should function
        // like the toString method of the Array class but specific to
        // creating a histogram.
    
        // You may want to create an instance of the
        // StringBuilder class to assist you in this method.
        // Follow the code in the method getHeaderAsString
        // as a guide. You can also use string concatenation.
        return str;
    }

    // This method should create and return an array of integers
    // that represents the resulting histogram from the numbers
    // entered and passed to the method.
    //
    
    // validates the range of numbers
    public static boolean validInput( double num ) {
        if (num > UPPER_BOUND || num < LOWER_BOUND)
            return false;
        return true;
    }

    // allows the user to input numbers into the histogram
    public static double [] inputNumbers(Scanner scan) {
        
        double [] array = new double [MAX_NUMBERS];   

        int i = 0;

        // allows only a max of 20 or exits loop when entered sentienal 
        while (i < array.length && i <= MAX_NUMBERS) {
            double n = scan.nextDouble();
            if (n == SENTINAL)
                break;
            if (validInput(n)) {
                array[i] = n;
            }
            else {
                i--;
                System.out.println("Enter a valid number.");
            }
                
            i++;
        }
        double [] changeArray = new double[i];

        for (int j = changeArray.length - 1; j >= 0; j--) {
            changeArray[j] = array[j];
        }

        return changeArray;
    }
} // end of class