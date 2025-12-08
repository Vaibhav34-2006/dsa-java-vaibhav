package sorting;

public class sorting_3 {

    // Insertion Sort Algorithm
    
    public static void insertionsort(int arr[]) {

        // Start from index 1 because index 0 is considered sorted
        for (int i = 1; i < arr.length; i++) {

            int curr = arr[i];   // current element to insert
            int prev = i - 1;    // previous index

            // Shift elements to the right until correct position is found
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // Insert current element in the correct position
            arr[prev + 1] = curr;
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

        int arr[] = {5, 4, 1, 3, 2};

        insertionsort(arr);  // Sorting

        printarr(arr);       // Printing sorted array
    }
}
