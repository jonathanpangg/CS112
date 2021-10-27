/*
 * Student First Name: Jonathan
 * Student Last Name: Pang
 * Student BU Number: U57363592
 * Purpose: StringRecursion Class 
 */

public class StringRecursion {
    // prints a string in reverse by going in reverse and taking the last char
    public static void printReverse(String str) {
        if (str == null || str == "") 
            return;

        System.out.print(str.charAt(str.length() - 1));
        printReverse(str.substring(0, str.length() - 1));
    }

    // gets rid of leading and trailing spaces by going both ways 
    public static String trim(String str) {
        if (str.isEmpty() || str == null) {
            return "";
        }
        
        if (str.charAt(0) == ' ')
            return trim(str.substring(1));
        else 
            return trim(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
    }

    // finds a char in a string by going in reverse
    public static int find(char ch, String str) {
        if (str.isEmpty() || str == null) {
            return -1;
        }

        int returnVal = -1;

        if (str.charAt(str.length() - 1) == ch) {
            if (!(str.substring(0, str.length() - 1)).contains(ch + ""))
                returnVal = str.length() - 1;
            else 
                returnVal = find(ch, str.substring(0, str.length() - 1));
        }
        else if (str.length() > 1) 
            returnVal = find(ch, str.substring(0, str.length() - 1));
        
        return returnVal;
    }

    // interweaves two strings by taking all the cases
    public static String weave(String str1, String str2) {
        if ((str1.isEmpty() || str1 == null) && (str2.isEmpty() || str2 == null)) {
            return "";
        }

        else if (str1.isEmpty() || str1 == null) {
            return "" + str2.charAt(0) + weave(str1, str2.substring(1));
        }

        else if (str2.isEmpty() || str2 == null) {
            return "" + str1.charAt(0) + weave(str1.substring(1), str2);
        }

        else {
            return "" + str1.charAt(0) + str2.charAt(0) + weave(str1.substring(1), str2.substring(1));
        }
    }

    // returns the indexOf the char in the string by going in reverse
    public static int indexOf(char ch, String str) {
        if (str.isEmpty() || str == null) {
            return -1;
        }

        int returnVal = -1;

        if (str.charAt(str.length() - 1) == ch) {
            if (!(str.substring(0, str.length() - 1)).contains(ch + ""))
                returnVal = str.length() - 1;
            else 
                returnVal = indexOf(ch, str.substring(0, str.length() - 1));
        }
        else if (str.length() > 1) 
            returnVal = indexOf(ch, str.substring(0, str.length() - 1));
        
        return returnVal;
    }

    public static void main(String [] args) {
        printReverse("Terriers");
        System.out.println();
        System.out.println(trim(" hello world    "));
        System.out.println(trim("recursion  "));
        System.out.println( weave("aaaa", "bbbb") );
        System.out.println( weave("hello", "world") );
        System.out.println( indexOf('b', "Rabbit") ); 
        System.out.println( indexOf('P', "Rabbit") );
    }
}
