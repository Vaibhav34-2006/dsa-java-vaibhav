package sorting;
import java.util.Arrays;
import java.util.Collections;

public class sorting_7 {

    // Function to print array elements
    public static void printarr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Using Integer[] because reverseOrder() cannot work with primitive int[]
        Integer arr[] = {5, 4, 1, 3, 2};

        int si = 1;  // start index (inclusive)
        int ei = 4;  // end index (exclusive)

        /*
         * Arrays.sort(arr, si, ei, comparator)
         * si = starting index (included)
         * ei = ending index (excluded)
         * Only arr[si] to arr[ei-1] is reverse sorted
         */
        Arrays.sort(arr, si, ei, Collections.reverseOrder());
       
        // Print final array
        printarr(arr);
    }
}
