import java.util.Arrays;

public class Duplicates {
    public static int removeDups(int [] arr) {
        int counter = 0;

        int i = 0;
        int j = 1;

        while (i < arr.length && j < arr.length) {
            if (arr[i] != arr[j]) {
                i++;
                if (arr[i] == 0 && arr[j] != 0) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                }  
            }

            else {
                arr[j] = 0;
                counter++;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr));

        return arr.length - counter;
    }

    public static void main(String [] args) {
        int [] arr = {2, 5, 5, 5, 5, 10, 10, 12, 12};
        System.out.println(removeDups(arr));
    }
}
