package sorting;

public class sorting_10 {

    // Function to print array elements
    public static void printArr(int arr[]) {
        // Loop through each element of array
        for (int i = 0; i < arr.length; i++) {
            // Print element with space
            System.out.print(arr[i] + " ");
        }
        // Move to next line after printing array
        System.out.println();
    }

    // Quick Sort function
    // arr[] = array to be sorted
    // si = starting index
    // ei = ending index
    public static void quicksort(int arr[], int si, int ei) {

        // Base case: if starting index is greater than or equal to ending index
        if (si >= ei) {
            return;
        }

        // Partition the array and get pivot index
        int pidx = parition(arr, si, ei);

        // Recursively sort left part (before pivot)
        quicksort(arr, si, pidx - 1);

        // Recursively sort right part (after pivot)
        quicksort(arr, pidx + 1, ei);
    }

    // Partition function
    // It places pivot element at correct position
    // and arranges smaller elements on left and larger on right
    private static int parition(int[] arr, int si, int ei) {

        // Take last element as pivot
        int pivot = arr[ei];

        // Index for placing smaller elements
        int i = si - 1;

        // Traverse array from si to ei-1
        for (int j = si; j < ei; j++) {

            // If current element is smaller than pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // Place pivot at its correct position
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        // Return pivot index
        return i;
    }

    public static void main(String[] args) {

        // Given array
        int arr[] = {6, 3, 9, 5, 2, 8};

        // Apply Quick Sort
        quicksort(arr, 0, arr.length - 1);

        // Print sorted array
        printArr(arr);
    }
}
