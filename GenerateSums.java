/**
 * GenerateSums.java
 * 
 * Implementation of a class that prints the sums 
 * of a number, n
 *
 * Computer Science 112, Boston University
 *
 * your name: Jonathan Pang
 *
 */

public class GenerateSums {
    public static String generateSums(int n) { // returns the sums of a number
        int sum = 0;
        String s = "";
        String copy = "";

        for (int i = 1; i <= n; i++) {
            sum += i;

            if (i == 1) {
                copy += (i + "");
                s += (copy + "\n");
            }

            else if (i < n) {
                copy += (" + " + i);
                s += (copy + " = " + sum + "\n");
            }

            else {
                copy += (" + " + i);
                s += (copy + " = " + sum);
            }
        }

        return s;
    }
}