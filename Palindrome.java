/*
 * Palindrome.java
 * 
 * Jonathan Pang
 * Class to determine if String is palindrome
 */
   
import java.util.*;

public class Palindrome {
    // Add your definition of isPal here.
    public static boolean isPal(String str) { // determines if a string is a palindrome
        if (str == null) 
            throw new IllegalArgumentException();
        str = str.toLowerCase(); 
        Stack <String> stack = new LLStack <>(); // stack to determine if string is a palindrome
        Stack <String> temp = new LLStack<>(); // temp stack
        int count = 0; // index 

        String specialLetters = "-+[]{}\\|;:'\"!@#$%^&*()~`/,<.>?_="; // special letters that are omitted when determining if a string is a palindrome
        
        // removes all special letters and white spaces and puts it into the temp stack
        for (int i = str.length() - 1; i >= 0; i--) {
            if (specialLetters.contains("" + str.charAt(i)) || ("" + str.charAt(i)).equals(" ")) {
                if (i + 1 < str.length())
                    str = str.substring(0, i) + str.substring(i + 1);
                else 
                    str = str.substring(0, i);

            }
            else 
                temp.push("" + str.charAt(i));
        }
            
        // removes all elements in temp and sees if stack will be empty (a palindrome)
        while (!temp.isEmpty()) {
            String test = temp.pop();
            if (!stack.isEmpty()) {
                if (count != str.length() / 2 && str.length() % 2 != 0) {
                    if (!(stack.peek().equals(test))) 
                        stack.push(test);
                    else 
                        stack.pop();
                }

                if (str.length() % 2 == 0) {
                    if (!(stack.peek().equals(test))) 
                        stack.push(test);
                    else 
                        stack.pop();
                }
            }
            else
                stack.push(test);

            count++;
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println(); // include a blank line between tests
        
        /*
         * Add five more unit tests that test a variety of different
         * cases. Follow the same format that we have used above.
         */

        /*
        Test Case #1
        Check for punctation
        */

        System.out.println("(1) Testing on \"Wow, banana ananab WOW!\"");
        try {
            boolean results = isPal("Wow, banana ananab WOW!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println();

        /*
        Test Case #2
        Checks if a non-palindrome works
        */ 

        System.out.println("(2) Testing on \"Hello, what is your name?\"");
        try {
            boolean results = isPal("Hello, what is your name?");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();

        /*
        Test Case #3
        Checks if odd length string (with punctation) work
        */

        System.out.println("(3) Testing on \"ananananaanananana?????\"");
        try {
            boolean results = isPal("ananananaanananana?????");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
        
        /*
        Test Case #4
        null
        */

        System.out.println("(4) Testing on \"null\"");
        try {
            boolean results = isPal(null);
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();

        /*
        Test Case #5
        Checks if odd length string (with punctation and capital letters and spaces) work
        */

        System.out.println("(5) Testing on \"@An a N aN ANA An  a  n an ana ?\"");
        try {
            boolean results = isPal("@An a N aN ANA An  a  n an ana ??");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
    }
}
