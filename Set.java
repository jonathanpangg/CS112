/*
 * Student First Name: Jonathan
 * Student Last Name: Pang
 * Student BU Number: U57363592
 * Purpose: Set Class 
 */

import java.util.*;

public class Set {
    private static final int SIZE = 10; // default size of initial set
                                
    private int[] set;      // array referece to the set
    private int size;       // current size of the set
    private int next;       // index to next available slot in the set array
    
    // constructor for no args
    public Set() {
        this.set = new int [SIZE];
        this.size = SIZE;
        this.next = 0;
        min();
    }
 
    // constructor for arr param
    public Set(int[] arr) {
        this.set = arr;
        this.size = arr.length;
        this.next = this.size;
        min();
    }

    // helper method to get rid of trailing zeros 
    public void min() {
        int index = -1;
        
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.set[i] != 0) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            this.set = new int [0];
            this.size = 0;
            this.next = 0;
        }

        else if (index != this.size - 1) {
            int [] copy = new int [index + 1];

            for (int i = 0; i <= index; i++) {
                copy[i] = this.set[i];
            }

            this.set = copy;
            this.size = copy.length;
            this.next = this.size;
        }
    }

    // helper method for trailing zeros (special case)
    public void minForZero() {
        int index = -1;

        if (this.size > 1) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (this.set[i] != 0) {
                    index = i + 1;
                    break;
                }
            }
    
            if (index != this.size - 1 && index != -1) {
                int [] copy = new int [index + 1];
    
                for (int i = 0; i <= index; i++) {
                    copy[i] = this.set[i];
                }
    
                this.set = copy;
                this.size = copy.length;
                this.next = this.size;
            }
        }
    }

    // copies a Set 
    public Set clone() {
        min();

        int [] arr = new int [this.size];

        for (int i = 0; i < this.size; i++) {
            arr[i] = this.set[i];
        }

        return new Set(arr);
    }

    /** 
     * This method reallocates the array set to twice as 
     * big and copies all the elements over.
     * This method is called only by the insert method
     * when it cannot insert another element to the set.
     *
     * Note that this is the reason that in this class
     * the member size is not a class variable (i.e. static)
     * and it is not final, because the set can grow and size
     * will be modified accordingly.
     */
    
    private void resize() {
        if (size != 0) {
            size *= 2;

            // Create a new array double the size
            int[] temp = new int[size];

            // Copy all the elements from the current set
            // to the new set
            for(int i = 0; i < set.length; ++i) {
                temp[i] = set[i];
            }

            // Assign to the set reference the newly
            // resized array that represents the set.
            set = temp;
        }
        else {
            size = 1;
            int[] temp = new int[size];

            // Copy all the elements from the current set
            // to the new set
            for(int i = 0; i < set.length; ++i) {
                temp[i] = set[i];
            }

            set = temp;
        }
    }
 
    // returns the string representation of the Set
    public String toString()  {
        String s = "[";
        
        for (int i = 0; i < this.size; i++) {
            if (i + 1 == this.size)
                s += (this.set[i]);
            else
                s += (this.set[i] + ",");
        }

        s += "]";

        return s;
    } 
    
    // returns the length of the Set
    public int cardinality() {
        return this.size;
    }

    // returns if the set is empty or not
    public boolean isEmpty() {
        return (this.size == 0);
    }
     
    // returns if k is in the set
    public boolean member(int k) {
        for (int i = 0; i < this.size; i++) {
            if (k == this.set[i])
                return true;
        }
        return false;
    }    
   
    // returns if S is a subset of this
    public boolean subset(Set S) {
        for (int i = 0; i < this.size; i++) {
            if (!S.member(this.set[i])) 
                return false;
        }
        return true;
    }
    
    // retursn if S is equal to this
    public boolean equal(Set S) {
        if (this.size != S.cardinality()) 
            return false;

        int [] temp1 = new int [this.size];
        int [] temp2 = new int [S.size];

        for (int i = 0; i < temp1.length; i++) {
            temp1[i] = this.set[i];
            temp2[i] = S.set[i];
        }

        Arrays.sort(temp1);
        Arrays.sort(temp2);

        for (int i = 0; i < this.size; i++) {
            if (temp1[i] != temp2[i])
                return false;
        }

        return true;
    }
    
    // inserts an element to the Set
    public void insert(int k) {
        if (member(k))
            return;

        if (k == 0) {
            resize();
            minForZero();
            this.next++;
        }
        else {
            try {
                this.set[this.next] = k;
                this.next++;
               // System.out.println("here");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                resize();
                insert(k);
                min();
            }
        }
    }
    
    // deletes the k element
    public void delete(int k) {
        boolean isDeleted = false;
        int saveIndex = -1;
        
        for (int i = 0; i < this.size; i++) {
            if (k == this.set[i]) {
                this.set[i] = 0;
                saveIndex = i;
                isDeleted = true;
                break;
            }
        }

        if (isDeleted) {
            for (int i = saveIndex; i < this.size - 1; i++) {
                this.set[i] = this.set[i+1];
            }
            this.next--;
            this.size--;
        }

        min();
    }
  
    // returns the union of two sets
    public Set union(Set S) {
        Set res = new Set();

        for (int i = 0; i < this.size; i++) {
            res.insert(this.set[i]);
        }

        for (int i = 0; i < S.size; i++) {
            if (!res.member(S.set[i])) 
                res.insert(S.set[i]);
        }

        res.min();
        
        return res;
    }
   
    // returns the intersection of two sets
    public Set intersection(Set S) {
        Set res = new Set();

        for (int i = 0; i < this.size; i++) {
            innerloop:
            for (int j = 0; j < S.size; j++) {
                if ((this.set[i] == S.set[j]) && (!res.member(this.set[i]))) {
                    res.insert(this.set[i]);
                    break innerloop;
                }   
            }
        }

        res.min();
        return res;
    }
    
    // returns the set difference of two sets
    public Set setdifference(Set S) {
        Set res = new Set();

        for (int i = 0; i < this.size; i++) {
            res.insert(this.set[i]);
        }
 
        for (int i = 0; i < S.size; i++) {
            if (res.member(S.set[i])) {
                res.delete(S.set[i]);
                i--;
            }
        }

        res.min();
        return res;
    }

    public static void main(String [] args) {
        System.out.println("\nUnit Test for Set: note that your answers, when they are");
        System.out.println("  sets, could be in a different order (since order does");
        System.out.println("  not matter), this is the meaning of \"same set as...\"\n");
        
        Set A = new Set();
        Set B = new Set( new int[] { 5 } );
        Set C = new Set( new int[] { 5, 3, 7, 4, 1 } );
        Set D = new Set( new int[] { 4, 3, -3, 10, 8 } );
        Set E = new Set( new int[] { 8, 4, 10 } );
        Set F = new Set( new int[] { 10, 8, 4 } );
        
        System.out.println("Test 01: Should be\n[]");
        System.out.println(A);
        System.out.println(); 
        
        System.out.println("Test 02: Should be\n[5]");
        System.out.println(B);
        System.out.println(); 
        
        System.out.println("Test 03: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C);
        System.out.println(); 
        
        System.out.println("Test 04: Should be\n[]");
        System.out.println(A.clone());
        System.out.println(); 
        
        System.out.println("Test 05: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.clone());
        System.out.println(); 
        
        System.out.println("Test 06: Should be\n0");
        System.out.println(A.cardinality());
        System.out.println(); 
        
        System.out.println("Test 07: Should be\n5");
        System.out.println(D.cardinality());
        System.out.println(); 
        
        System.out.println("Test 08: Should be\ntrue");
        System.out.println(A.isEmpty());
        System.out.println(); 
        
        System.out.println("Test 09: Should be\nfalse");
        System.out.println(F.isEmpty());
        System.out.println(); 
        
        System.out.println("Test 10: Should be\nfalse");
        System.out.println(A.member(4));
        System.out.println();
        
        System.out.println("Test 11: Should be\ntrue");
        System.out.println(C.member(1));
        System.out.println();       
        
        System.out.println("Test 12: Should be\nfalse");
        System.out.println(D.member(1));
        System.out.println();
        
        System.out.println("Test 13: Should be\ntrue");
        System.out.println(A.subset(D));
        System.out.println();
        
        System.out.println("Test 14: Should be\nfalse");
        System.out.println(D.subset(C));
        System.out.println();       
        
        System.out.println("Test 15: Should be\ntrue");
        System.out.println(E.subset(D));
        System.out.println();
        
        System.out.println("Test 16: Should be\nfalse");
        System.out.println(D.subset(E));
        System.out.println();
        
        System.out.println("Test 17: Should be\nfalse");
        System.out.println(D.equal(E));
        System.out.println();       
        
        System.out.println("Test 18: Should be\ntrue");
        System.out.println(E.equal(F));
        System.out.println();
        
        System.out.println("Test 19: Should be\ntrue");
        System.out.println(F.equal(E));
        System.out.println();
        
        System.out.println("Test 20: Should be\ntrue");
        System.out.println(A.equal(A));
        System.out.println();       
        
        System.out.println("Test 21: Should be same set as\n[4,6]");
        Set A1 = A.clone(); 
        A1.insert(4);
        A1.insert(6);
        A1.insert(4);
        System.out.println(A1);
        System.out.println();
        
        System.out.println("Test 22: Should be same set as\n[10,8,4,5]");
        Set F1 = F.clone(); 
        F1.insert(5);
        F1.insert(4);
        System.out.println(F1);
        System.out.println();       
        
        System.out.println("Test 23: Should be same set as\n[8,4,10]");
        Set E1 = E.clone(); 
        E1.insert(10);
        System.out.println(E1);
        System.out.println();
        
        System.out.println("Test 24: Should be\n[]");
        A1 = A.clone(); 
        A1.delete(5);
        System.out.println(A1);
        System.out.println();       
        
        System.out.println("Test 25: Should be\n[]");
        Set B1 = B.clone(); 
        B1.delete(5);
        System.out.println(B1);
        System.out.println();  
        
        System.out.println("Test 26: Should be same set as\n[8,4,10]");
        E1 = E.clone(); 
        E1.delete(5);
        System.out.println(E1);
        System.out.println(); 
        
        System.out.println("Test 27: Should be same set as\n[4,10]");
        E1 = E.clone(); 
        E1.delete(8);
        System.out.println(E1);
        System.out.println();
        
        System.out.println("Test 28: Should be same set as\n[3,4]");
        System.out.println(C.intersection(D));
        System.out.println();
        
        System.out.println("Test 29: Should be\n[8,4,10]");
        System.out.println(E.intersection(F));
        System.out.println();       
        
        System.out.println("Test 30: Should be same set as\n[]");
        System.out.println(A.intersection(F));
        System.out.println();
        
        System.out.println("Test 31: Should be same set as\n[]");
        System.out.println(B.intersection(F));
        System.out.println();
        
        System.out.println("Test 32: Should be same set as\n[4,3,-3,10,8,5,7,1]");
        System.out.println(C.union(D));
        System.out.println();
        
        System.out.println("Test 33: Should be same set as\n[10,8,4]");
        System.out.println(E.union(F));
        System.out.println();       
        
        System.out.println("Test 34: Should be same set as\n[10,8,4]");
        System.out.println(A.union(F));
        System.out.println();
        
        System.out.println("Test 35: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.union(B));
        System.out.println();
        
        System.out.println("Test 36: Should be same set as\n[5,7,1]");
        System.out.println(C.setdifference(D));
        System.out.println();       
        
        System.out.println("Test 37: Should be same set as\n[]");
        System.out.println(E.setdifference(F));
        System.out.println();
        
        System.out.println("Test 38: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.setdifference(A));
        System.out.println();
        
        System.out.println("Test 39: Should be same set as\n[]");
        System.out.println(C.setdifference(C));
        System.out.println();
        
        System.out.println("Test 40: Should be same set as\n[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]");
        Set G = new Set();
        for(int i = 0; i < 32; ++i) {
            G.insert(i);
        }
        System.out.println(G);
        System.out.println();
    } // main()  
}