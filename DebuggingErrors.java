/* 
 * Lab  1 - DebuggingErrors Exercise #2
 * 
 * Practice Debugging a program with Methods
 *
 * name:
 * email:
 *
 * Fix all the bugs in this file! Then run it and add some extra test to make
 * sure everything works
 *
 */

public class DebuggingErrors {

    public static double triArea(double b, double h) {
	    double area = b/2*h;
	    return area;
    }
	
    public static void main(String[] args) {
        System.out.printf("Running Debugging.java\n");
        double a = triArea(5,3);
        System.out.printf("Area is: %f\n", a);
        System.out.println(DebuggingErrors.triArea(10, 3));
        System.out.println(DebuggingErrors.triArea(9, 3));
    }
}