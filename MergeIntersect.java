import java.util.Arrays;

public class MergeIntersect {
    /* merge - helper method for mergesort */
    private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
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
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }

    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end)/2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    
    /** mergesort */
    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }

    public static int [] intersect(int [] a, int [] b) {
        mergeSort(a);
        mergeSort(b);

        int i = 0;
        int j = 0;
        int k = 0;
        int prevAdded = 0;
        boolean ifAdded = false;

        int end = 0;
        if (a.length > b.length) 
            end = b.length;
        else 
            end = a.length;

        int [] c = new int [end];
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) 
                i++;

            else if (a[i] > b[j]) 
                j++;
            
            else {
                if (prevAdded != a[i] || !ifAdded) {
                    c[k] = a[i];
                    prevAdded = c[k];
                    ifAdded = true;
                }
                i++; j++; k++;
            }
        }

        return c;
    }

    public static void main(String [] args) {
        int[] a1 = {-1, 0, 2, 2};
        int[] a2 = {0, 2, 2};
        int [] c = intersect(a1, a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(c));
    }
}
