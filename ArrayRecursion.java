/*
 * Student First Name: Jonathan
 * Student Last Name: Pang
 * Student BU Number: U57363592
 * Purpose: ArrayRecursion Class 
 */

public class ArrayRecursion {
    // searches through the given arr
    public static boolean search(Object item, Object [] arr, int start) {
        if (arr == null || item == null) {
           throw new IllegalArgumentException();
        }
     
        if (start == arr.length) {
            return false;
        }
     
        if (arr[start].equals(item)) 
            return true;
        else 
            return false || search(item, arr, start + 1); 
    }

    // return the reverse of the Array as a String
    public static String reverseArrayToString(Object [] arr, int index) {
        if (arr == null) {
            return "";
        }

        if (index == 0)
            return "[" + arr[arr.length - 1 - index] + ", " + reverseArrayToString(arr, index + 1);
        else if (index < arr.length - 1)
            return arr[arr.length - 1 - index] + ", " + reverseArrayToString(arr, index + 1);
        else 
            return arr[arr.length - 1 - index] + "]";
    }
}
