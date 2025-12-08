package sorting;
import java.util.Arrays;

public class sorting_5 {

    // Function to print array elements
    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);   // print each element
        }
        System.out.println();  // extra line for spacing
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 3, 2};  // input array

        // Sorting only a specific portion of the array
        // Arrays.sort(arr, fromIndex, toIndex)
        // fromIndex = 0 → start position (inclusive)
        // toIndex = 3 → end position (exclusive)
        // So, it will sort arr[0], arr[1], arr[2]  → only first 3 elements
        Arrays.sort(arr, 0, 3);

        // Print the partially sorted array
        printarr(arr);
    }
}
