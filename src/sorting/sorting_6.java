package sorting;
import java.util.Arrays;
import java.util.Collections;

public class sorting_6 {

    // Function to print array elements
    public static void printarr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);   // print each element
        }
        System.out.println();  // space after printing
    }

    public static void main(String[] args) {

        // Integer[] is required because reverseOrder() works with objects, not primitive int
        Integer arr[] = {5, 4, 1, 3, 2};

        // Sorting array in descending order (largest → smallest)
        // Arrays.sort(array, comparator)
        // Collections.reverseOrder() provides a comparator for reverse sorting
        Arrays.sort(arr, Collections.reverseOrder());

        // Print sorted array
        printarr(arr);
    }
}
