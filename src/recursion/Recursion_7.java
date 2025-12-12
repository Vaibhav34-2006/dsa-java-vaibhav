package recursion;

public class Recursion_7 {

    // Function to find first occurrence of key in array
    public static int firstocc(int arr[], int key, int i) {

        // Base case: if we reach end of array → key not found
        if (i == arr.length) {
            return -1;
        }

        // If current element matches key → return index
        if (arr[i] == key) {
            return i;
        }

        // Recursive call → check next index
        return firstocc(arr, key, i + 1);
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 5, 4, 6, 6, 4, 3};
        int key = 6;

        // Print first index where key occurs
        System.out.println(firstocc(arr, key, 0));   // Output: 4
    }
}
