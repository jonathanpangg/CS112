
import java.util.*;

public class test {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int []partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last)/2];
        int i = first - 1;  // index going left to right
        int j = last + 1;   // index going right to left
        
        do {
            // moving from left to right, find an element >= the pivot
            do {
                i++;
            } while (arr[i] < pivot);
            
            // moving from right to left, find an element <= the pivot
            do {
                j--;
            } while (arr[j] > pivot); 
            
            // If the indices still haven't met or crossed,
            // swap the elements so that they end up in the correct subarray.
            // Otherwise, the partition is complete and we return j.
            if (i < j) {
                swap(arr, i, j);
            }

        } while ( i < j );
        return(arr);
    }

    public static int [] merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        // {24, 3, 27, 13, 34, 2, 50, 12}, arr.length = 8, leftStart = 0, leftEnd = 4, rightStart = 5, rightEnd = 8

        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
        // {24, 3, 27, 13, 34} | {2, 50, 12}
        // {2, 24, 3, 27, 13, 34, 50, 12}
        // {2, 24, 3, 27, 13} | {34, 50, 12}
        // {}
        System.out.println(j);
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i]; 
                i++; k++;
            } else {
                temp[k] = arr[j]; 
                j++; k++;
            }
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; k++;
        }

        // {14, 7, 24, 20, 10, 13, , 0}
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
        
        return temp;
    }

    public static void main(String [] args) {
        int [] arr = {24, 3, 27, 13, 34, 2, 50, 12};
        int [] temp = new int [8];
        // System.out.println(Arrays.toString((partition(arr, 0, arr.length - 1)))); 
        // System.out.println(Arrays.toString(partition(partition(arr, 0, arr.length - 1), 0, arr.length - 1))); 
        // System.out.println(Arrays.toString(merge(arr, temp, 0, arr.length / 2, arr.length / 2 + 1, arr.length - 1)));
        // System.out.println(Arrays.toString(merge(merge(arr, temp, 0, arr.length / 2, arr.length / 2 + 1, arr.length - 1), temp, 0, arr.length / 2, arr.length / 2 + 1, arr.length - 1)));
        // System.out.println(Arrays.toString((partition(arr, 0, arr.length - 1)))); 
        // System.out.println(Arrays.toString(merge(arr, temp, 0, arr.length / 2, arr.length / 2 + 1, arr.length)));
        
        
    }
}