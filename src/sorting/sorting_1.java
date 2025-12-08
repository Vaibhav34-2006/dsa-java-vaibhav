package sorting;

public class sorting_1 {

    // Bubble Sort Algorithm
    public static void bubblesort(int arr[]) {

        // Outer loop → runs (n - 1) times
        for (int turn = 0; turn < arr.length; turn++) {

            // Inner loop → compares adjacent elements
            for (int j = 0; j <= arr.length - 2 - turn; j++) {

                // If current element is greater than next → swap them
                if (arr[j] > arr[j+1]) {

                    // Swapping arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Function to print array elements
    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Input array
        int arr[] = {5, 4, 1, 3, 2};

        // Sort the array
        bubblesort(arr);

        // Print the sorted array
        printarr(arr);
    }
}
