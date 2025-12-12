package recursion;

public class Recursion_8 {

    // Function to return LAST occurrence of key in array
    public static int lastocc(int arr[], int key, int i) {

        // Base case: if index reaches end → return -1 (not found)
        if (i == arr.length) {
            return -1;
        }

        // Recursive call: check in the rest of the array first
        int isFound = lastocc(arr, key, i + 1);

        // If key was NOT found later and current element matches → this is last occurrence
        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        // Otherwise return whatever was found later
        return isFound;
    }

    public static void main(String[] args) {

        int arr[] = {2, 5, 3, 5, 8, 5, 8};
        int key = 5;

        // Print the last occurrence index
        System.out.println(lastocc(arr, key, 0));  // Output: 5
    }
}
