import java.util.Arrays;

public class PairFinder {
    public static void findPairSums(int k, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                }
            }
        }
    }
    
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

    public static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end)/2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    
    /** mergesort */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }

    public static void findPairSumsFaster(int k, int[] arr) {
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        int start = 0;
        int end = arr.length - 1;

        while (start < end && start >= 0 && end < arr.length) {
            if (arr[start] + arr[end] == k) {
                System.out.println(arr[start] + " + " + arr[end] + " = " + k);
                boolean pass1 = false;
                boolean pass2 = false;
                if (start + 1 != end && arr[start] == arr[start + 1]) {
                    System.out.println(arr[start] + " + " + arr[end] + " = " + k);
                    pass1 = true;
                }
                if (end - 1 != start && arr[end] == arr[end - 1]) {
                    System.out.println(arr[start] + " + " + arr[end] + " = " + k);
                    pass2 = true;
                }

                if (pass1 && !pass2) {
                    start+=2;
                }

                else if (!pass1 && pass2) {
                    end-=2;
                }

                else {
                    start++;
                    end--;
                }
            }
            else if (arr[start] + arr[end] > k) {
                end--;
            }
            else {
                start++;
            }
        }
    }

    public static void main(String [] args) {
        int [] arr = {10, 4, 7, 7, 8, 5, 5, 15};
        // findPairSums(12, arr);
        findPairSumsFaster(12, arr);
    }
}
