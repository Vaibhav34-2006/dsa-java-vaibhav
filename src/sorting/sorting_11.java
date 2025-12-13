package sorting;


public class sorting_11 {

    // Function to search target element in sorted & rotated array
    // arr[] = given array
    // tar   = target element
    // si    = starting index
    // ei    = ending index
    public static int search(int arr[], int tar, int si, int ei) {

        // Base case: if search space becomes invalid
        if (si > ei) {
            return -1; // target not found
        }

        // Calculate mid index safely
        int mid = si + (ei - si) / 2;

        // Case 1: target found at mid
        if (arr[mid] == tar) {
            return mid;
        }

        // Check which part is sorted

        // Case 2: Left half is sorted
        if (arr[si] <= arr[mid]) {

            // Check if target lies in left half
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1); // search left
            } else {
                return search(arr, tar, mid + 1, ei); // search right
            }
        }

        // Case 3: Right half is sorted
        else {

            // Check if target lies in right half
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei); // search right
            } else {
                return search(arr, tar, si, mid - 1); // search left
            }
        }
    }

    public static void main(String[] args) {

        // Sorted & rotated array
        int arr[] = {4, 5, 6, 7, 0, 1, 2};

        int target = 0;

        // Function call
        int index = search(arr, target, 0, arr.length - 1);

        // Output result
        if (index == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index: " + index);
        }
    }
}

