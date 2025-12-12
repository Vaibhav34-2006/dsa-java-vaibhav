package recursion;

public class Recursion_6 {

    // Function to check if array is sorted in increasing order
    public static boolean issorted(int arr[], int i) {

        // Base case: if we reach last element, array is sorted
        if (i == arr.length - 1) {
            return true;
        }

        // If current element is greater than next, array is NOT sorted
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        // Recursive call: check rest of the array
        return issorted(arr, i + 1);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};

        // Print whether array is sorted
        System.out.println(issorted(arr, 0));  // Output: true
    }
}
