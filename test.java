import java.util.*;

public class test {
    private static final int SIZE = 20;
    private static int[] digits = new int[SIZE];;
    private static int numSigDigits;

    public static void BigInt(int[] arr) { // sets the given arr equal to digits
        if (arr.length > 20) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 10)
                throw new IllegalArgumentException();
        }

        int counter = arr.length - 1;
        for (int i = SIZE - 1; i >= SIZE - arr.length; i--) {
            digits[i] = arr[counter];
            counter--;
        }
        System.out.println(Arrays.toString(digits));
        numSigDigits = getNumSigDigits();
    }

    public static int getNumSigDigits() { // finds the number of digits in the arr by finding the first non-zero element
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) 
                return digits.length - i;
        }
        return 0;
    }

    public static BigInt add(BigInt other) { // adds two different BigInt Objects
        int [] arr = new int [SIZE];
        if (other == null) 
            throw new IllegalArgumentException();

        boolean carry = false;
        int counter = 0;
        int saveVal = 0;

        // first case where this length is greater than or equal to other length
        // adds in reverse order 
        if (this.getNumSigDigits() >= other.getNumSigDigits()) {
            for (int i = this.digits.length - 1; i > this.digits.length - 1 - this.getNumSigDigits(); i--) {
                int n = this.digits[i] + other.digits[other.digits.length - 1 - counter];
                
                if (carry) {
                    n += saveVal;
                    carry = false;
                    saveVal = 0;
                    if (arr.length - 1 - counter <= 0) 
                        throw new ArithmeticException();
                }
                
                if (arr.length - 1 - counter < 0) 
                    throw new ArithmeticException();
                
                if (other.digits.length - 1 - counter == 0) { // exits loop
                    i = 0;
                }
    
                if (n >= 10) { // incorporate carry operator
                    carry = true;
                    saveVal = n / 10;
                    n %= 10;
                }
                
                arr[arr.length - 1 - counter] = n;

                ++counter;
            }
            arr[arr.length - 1 - counter] = saveVal;
        }
        // other case where other length is greater than this length 
        else {
            for (int i = other.digits.length - 1; i > other.digits.length - 1 - other.getNumSigDigits(); i--) {
                int n = other.digits[i] + this.digits[this.digits.length - 1 - counter];
                if (arr.length - 1 - counter < 0) 
                    throw new ArithmeticException();
                    
                if (carry) {
                    n += saveVal;
                    carry = false;
                    saveVal = 0;
                    if (arr.length - 1 - counter <= 0) 
                        throw new ArithmeticException();
                } 
                
                if (this.digits.length - 1 - counter == 0) { // exits loop
                    i = 0;
                }
    
                if (n >= 10) { // incorporate carry operator
                    carry = true;
                    saveVal = n / 10;
                    n %= 10;
                }
                
                arr[arr.length - 1 - counter] = n;

                ++counter;
            }
        }
        
        return new BigInt(arr);
    }

    public static void main(String [] args) {
        int [] x = {5, 7, 4, 3, 1};
        BigInt(x);
    }
}

/*

public BigInt add(BigInt other) { // adds two different BigInt Objects
        int [] arr = new int [SIZE];
        if (other == null) 
            throw new IllegalArgumentException();

        boolean carry = false;
        int counter = 0;
        int saveVal = 0;

        // first case where this length is greater than or equal to other length
        // adds in reverse order 
        if (this.getNumSigDigits() >= other.getNumSigDigits()) {
            for (int i = this.digits.length - 1; i > this.digits.length - 1 - this.getNumSigDigits(); i--) {
                int n = this.digits[i] + other.digits[other.digits.length - 1 - counter];
                
                if (carry) {
                    n += saveVal;
                    carry = false;
                    saveVal = 0;
                    if (arr.length - 1 - counter <= 0) 
                        throw new ArithmeticException();
                }
                
                if (arr.length - 1 - counter < 0) 
                    throw new ArithmeticException();
                
                if (other.digits.length - 1 - counter == 0) { // exits loop
                    i = 0;
                }
    
                if (n >= 10) { // incorporate carry operator
                    carry = true;
                    saveVal = n / 10;
                    n %= 10;
                }
                
                arr[arr.length - 1 - counter] = n;

                ++counter;
            }
            arr[arr.length - 1 - counter] = saveVal;
        }
        // other case where other length is greater than this length 
        else {
            for (int i = other.digits.length - 1; i > other.digits.length - 1 - other.getNumSigDigits(); i--) {
                int n = other.digits[i] + this.digits[this.digits.length - 1 - counter];
                if (arr.length - 1 - counter < 0) 
                    throw new ArithmeticException();
                    
                if (carry) {
                    n += saveVal;
                    carry = false;
                    saveVal = 0;
                    if (arr.length - 1 - counter <= 0) 
                        throw new ArithmeticException();
                } 
                
                if (this.digits.length - 1 - counter == 0) { // exits loop
                    i = 0;
                }
    
                if (n >= 10) { // incorporate carry operator
                    carry = true;
                    saveVal = n / 10;
                    n %= 10;
                }
                
                arr[arr.length - 1 - counter] = n;

                ++counter;
            }
        }
        
        return new BigInt(arr);
    }
*/