import java.util.*;

public class midtermReviewArrays {
    // Lab 3 Task 3 Part 1
    public static int shiftLeft(int [] arr) {
        if (arr == null) 
            throw new IllegalArgumentException();
        int save = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }

        arr[arr.length - 1] = 0;
        return save;
    }

    // Lab 3 Task 3 Part 2
    public static int replace(int [] arr, int x, int y) {
        if (arr == null)
            throw new IllegalArgumentException();

        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                arr[i] = y;
                counter++;
            }
        }

        return counter;
    }

    // Lab 3 Task 3 Part 3
    public static int [] interleave(int [] a, int [] b) {
        if (a == null || b == null)
            throw new IllegalArgumentException();
        
        int [] res = new int [0];
        if (a.length >= b.length) {
            res = new int [b.length * 2];
            int counter = 0;
            for (int i = 0; i < b.length; i++) {
                res[counter] = a[i];
                counter++;
                res[counter] = b[i];
                counter++;
            }
        }
        else {
            res = new int [a.length * 2];
            int counter = 0;
            for (int i = 0; i < a.length; i++) {
                res[counter] = a[i];
                counter++;
                res[counter] = b[i];
                counter++;
            }
        }
        return res;
    }

    // Lab 3 Task 3 Part 4
    public static boolean isMirror(int [] a, int [] b) {
        if (a == null || b == null)
            throw new IllegalArgumentException();
        
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[a.length - 1 - i]) 
                return false;
        }
        return true;
    }

    // Lab 3 Task 3 Part 5
    public static boolean isMirror(String [] a, String [] b) {
        if (a == null || b == null)
            throw new IllegalArgumentException();
        
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b[a.length - 1 - i])) 
                return false;
        }
        return true;
    }
    
    public static void main(String [] args) {
        int[] a3 = {1, 2, 3, 4, 5, 6};
        System.out.println( shiftLeft(a3));
        System.out.println( Arrays.toString(a3));



        System.out.println();



        int[] a4 = {1, 2, 3, 2, 2, 6};
        int numReplaced;

        // first test
        numReplaced = replace(a4, 2, 9);
        System.out.println( Arrays.toString(a4) );
        System.out.println( "numReplaced = " + numReplaced );

        // second test
        numReplaced = replace(a4, 2, 9);
        System.out.println( Arrays.toString(a4) );
        System.out.println( "numReplaced = " + numReplaced);



        System.out.println();



        int[] a5 = {1, 2, 3, 4, 5};
        int[] a6 = {6, 7, 8, 9, 10};
        int[] a7 = interleave(a5, a6);
        System.out.println( Arrays.toString(a7) );



        System.out.println();



        int[] a8 = {1, 2, 3, 4, 5};
        int[] a9 = {5, 4, 3, 2, 1};
        System.out.println( isMirror(a8, a9) );

        int[] a10 = {1, 4, 5, 2, 1};
        System.out.println( isMirror(a8, a10) );



        System.out.println();



        String[] s1 = { "abc", "def", "ghi" };
        String[] s2 = new String[3];
        s2[0] = new String("ghi");
        s2[1] = new String("def");
        s2[2] = new String("abc");

        System.out.println( isMirror(s1, s2) );

        System.out.println(Integer.MAX_VALUE);
    }
}