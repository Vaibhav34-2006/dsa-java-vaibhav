package sorting;
import java.util.Arrays;

public class sorting_4 {

    // Function to print array elements
    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);   // print each element
        }
        System.out.println();  // extra line for spacing
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 3, 2};  // input array

        // Using built-in Java sorting method (Dual-Pivot QuickSort for primitives)
        Arrays.sort(arr);

        // Print sorted array
        printarr(arr);
    }
}
