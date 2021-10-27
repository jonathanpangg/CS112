import java.util.Arrays;

/* 
 * BigInt.java
 *
 * A class for objects that represent non-negative integers of 
 * up to 20 digits.
 * 
 * Jonathan Pang
 */

public class BigInt  {
    // the maximum number of digits in a BigInt -- and thus the length
    // of the digits array
    private static final int SIZE = 20;
    
    // the array of digits for this BigInt object
    private int[] digits;
    
    // the number of significant digits in this BigInt object
    private int numSigDigits;

    /*
     * Default, no-argument constructor -- creates a BigInt that 
     * represents the number 0.
     */
    public BigInt() { 
        this.digits = new int[SIZE];
        this.numSigDigits = 1;  // 0 has one sig. digit--the rightmost 0!
    }
    
    public BigInt(int[] arr) { // sets the given arr equal to digits
        this();
        if (arr == null)
            throw new IllegalArgumentException();
        
        if (arr.length > 20) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 10 || arr[i] < 0)
                throw new IllegalArgumentException();
        }

        int counter = arr.length - 1;
        for (int i = SIZE - 1; i >= SIZE - arr.length; i--) {
            this.digits[i] = arr[counter];
            counter--;
        }
        
        this.numSigDigits = getNumSigDigits();
    }

    public int getNumSigDigits() { // finds the number of digits in the arr by finding the first non-zero element
        for (int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] != 0) 
                return this.digits.length - i;
        }
        return 0;
    }

    public int [] getDigits() { // accessor method for the array       
        return this.digits;      
    }

    public String toString() { // returns the string representation of the big int
        String str = "";

        int counter = 0;
        while (counter < getNumSigDigits()) { // creates a counter and gets the indecies in revers
            str = this.digits[this.digits.length - counter - 1] + str;
            counter += 1;
        }

        if (getNumSigDigits() == 0)
            str = "0";
        return str;
    }

    public BigInt(int n) { // constructor for the parameter of a number
        this();
        if (n < 0) 
            throw new IllegalArgumentException();
        
        int num = n;
        int counter = 0;

        if (num == 0) {
            this.digits = new int [SIZE];
            this.numSigDigits = 1;
        }

        while (num != 0) {
            this.digits[this.digits.length - 1 - counter] = (num % 10);
            num /= 10;
            ++counter;
        }

        numSigDigits = getNumSigDigits();

    }

    public int compareTo(BigInt other) { // compares two different BigInt Objects
        if (other == null)  
            throw new IllegalArgumentException();
        
        // compares the length of the array first to find who is bigger 
        if (this.numSigDigits > other.numSigDigits) 
            return 1;

        else if (this.numSigDigits < other.numSigDigits) 
            return -1;
        
        // if arrays are the same size 
        else {
            // compare each index in ascending order 
            for (int i = 0; i < this.digits.length; i++) {
                if (this.digits[i] > other.digits[i]) 
                    return 1;

                else if (this.digits[i] < other.digits[i]) 
                    return -1;
            }
        }

        return 0;
    }

    public boolean ifZero(BigInt test) {
        if (test == null) 
            throw new IllegalArgumentException();

        for (int i = 0; i < SIZE; i++) {
            if (test.digits[i] != 0) 
                return false;
        
        }

        return true;
    }

    public boolean ifOne(BigInt test) {
        if (test == null) 
            throw new IllegalArgumentException();

        if (test.digits[SIZE - 1] != 1) 
            return false;

        for (int i = 0; i < SIZE - 1; i++) {
            if (test.digits[i] != 0) 
                return false;
        }

        return true;
    }

    public BigInt add(BigInt other) { // adds two different BigInt Objects
        if (other == null) 
            throw new IllegalArgumentException();
            
        int [] arr = new int [SIZE];

        if (this.numSigDigits < other.numSigDigits) { 
            BigInt temp = new BigInt(other.digits);
            other = new BigInt(this.digits);
            this.digits = temp.digits;
        }

        boolean save = false;
        int carry = 0;
        
        
        // System.out.println(Arrays.toString(this.digits));
        // System.out.println(Arrays.toString(other.digits));
        // System.out.println();
        
        for (int i = SIZE - 1; i >= 0; i--) {
            int n = this.digits[i] + other.digits[i];
            
            if (save) {
                n += carry;
                if (i < 0) 
                    throw new ArithmeticException();

                save = false;
            }
           
            if (i < 0) {
                throw new ArithmeticException();
            }

            if (n >= 10) {
                carry = (n / 10);
                n %= 10;
                save = true;
                if (i <= 0) 
                    throw new ArithmeticException();
            }

            arr[i] = n;
        }
        
        return new BigInt(arr);
    }

    public BigInt mul(BigInt other) { // multiples two different BigInt Objects
        if (other == null) 
            throw new IllegalArgumentException();
        
        int [] arr = new int [SIZE];

        if (this.numSigDigits < other.numSigDigits) { 
            BigInt temp = new BigInt(other.digits);
            other = new BigInt(this.digits);
            this.digits = temp.digits;
        }

        boolean save = false;
        int carry = 0;
        int counter = 0;

        BigInt number = new BigInt(0);

        // System.out.println(Arrays.toString(this.digits));
        // System.out.println(Arrays.toString(other.digits));
        // System.out.println();

        if (ifOne(other)) 
            return this;

        for (int i = SIZE - 1; i >= SIZE - 1 - other.numSigDigits; i--) {
            for (int j = SIZE - 1; j >= SIZE - 1 - this.numSigDigits; j--) {
                int n = other.digits[i] * this.digits[j];

                if (save) {
                    n += carry;
                    if (j - counter <= 0) 
                        throw new ArithmeticException();
    
                    save = false;
                }
    
                if (n >= 10) {
                    carry = (n / 10);
                    n %= 10;
                    save = true;
                }
    
                if (j - counter < 0)
                    throw new ArithmeticException();

                if (j - counter >= 0)
                    arr[j - counter] = n;
            }
            counter++;
            // System.out.println(Arrays.toString(arr));
            number = number.add(new BigInt(arr));
        }

        return number;
    }

    public static void main(String [] args) {
        System.out.println("Unit tests for the BigInt class.");
        System.out.println();

        /* 
         * You should uncomment and run each test--one at a time--
         * after you build the corresponding methods of the class.
         */
        
        System.out.println("Test 1: result should be 7");
        int[] a1 = { 1,2,3,4,5,6,7 };
        BigInt b1 = new BigInt(a1);
        System.out.println(b1.getNumSigDigits());
        System.out.println();
        
        System.out.println("Test 2: result should be 1234567");
        b1 = new BigInt(a1);
        System.out.println(b1);
        System.out.println();
        
        System.out.println("Test 3: result should be 0");
        int[] a2 = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
        BigInt b2 = new BigInt(a2);
        System.out.println(b2);
        System.out.println();
        
        System.out.println("Test 4: should throw an IllegalArgumentException");
        try {
            int[] a3 = { 0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
            BigInt b3 = new BigInt(a3);
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();

        System.out.println("Test 5: result should be 1234567");
        b1 = new BigInt(1234567);
        System.out.println(b1);
        System.out.println();

        System.out.println("Test 6: result should be 0");
        b2 = new BigInt(0);
        System.out.println(b2);
        System.out.println();

        System.out.println("Test 7: should throw an IllegalArgumentException");
        try {
            BigInt b3 = new BigInt(-4);
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();

        System.out.println("Test 8: result should be 0");
        b1 = new BigInt(12375);
        b2 = new BigInt(12375);
        System.out.println(b1.compareTo(b2));
        System.out.println();

        System.out.println("Test 9: result should be -1");
        b2 = new BigInt(12378);
        System.out.println(b1.compareTo(b2));
        System.out.println();

        System.out.println("Test 10: result should be 1");
        System.out.println(b2.compareTo(b1));
        System.out.println();

        System.out.println("Test 11: result should be 0");
        b1 = new BigInt(0);
        b2 = new BigInt(0);
        System.out.println(b1.compareTo(b2));
        System.out.println();
        
        System.out.println("Test 12: result should be\n123456789123456789");
        int[] a4 = { 3,6,1,8,2,7,3,6,0,3,6,1,8,2,7,3,6 };
        int[] a5 = { 8,7,2,7,4,0,5,3,0,8,7,2,7,4,0,5,3 };
        BigInt b4 = new BigInt(a4);
        BigInt b5 = new BigInt(a5);
        BigInt sum = b4.add(b5);
        System.out.println(sum);
        System.out.println();
        
        System.out.println("Test 13: result should be\n123456789123456789");
        System.out.println(b5.add(b4));
        System.out.println();

        System.out.println("Test 14: result should be\n3141592653598");
        b1 = new BigInt(0);
        int[] a6 = { 3,1,4,1,5,9,2,6,5,3,5,9,8 };
        b2 = new BigInt(a6);
        System.out.println(b1.add(b2));
        System.out.println();

        System.out.println("Test 15: result should be\n10000000000000000000");
        int[] a19 = { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 };    // 19 nines!
        b1 = new BigInt(a19);
        b2 = new BigInt(1);
        System.out.println(b1.add(b2));
        System.out.println();

        System.out.println("Test 16: should throw an ArithmeticException");
        int[] a20 = { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 };  // 20 nines!
        try {
            b1 = new BigInt(a20);
            System.out.println(b1.add(b2));
        } catch (ArithmeticException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();

        System.out.println("Test 17: result should be 5670");
        b1 = new BigInt(135);
        b2 = new BigInt(42);
        BigInt product = b1.mul(b2);
        System.out.println(product);
        System.out.println();
        
        System.out.println("Test 18: result should be\n99999999999999999999");
        b1 = new BigInt(a20);   // 20 nines -- see above
        b2 = new BigInt(1);
        System.out.println(b1.mul(b2));
        System.out.println();

        System.out.println("Test 19: should throw an ArithmeticException");
        try {
            b1 = new BigInt(a20);
            b2 = new BigInt(2);
            System.out.println(b1.mul(b2));
        } catch (ArithmeticException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();
    }
}
