package sorting;

public class sorting_2 {

    // Selection Sort Algorithm
    public static void selectionsort(int arr[]) {

        // Outer loop → selects each index one by one
        for (int i = 0; i < arr.length - 1; i++) {

            int minpos = i;  // assume current element is minimum

            // Inner loop → find the minimum element in remaining array
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[minpos] > arr[j]) {  // compare with current minimum
                    minpos = j;  // update index of smallest element
                }
            }

            // Swap smallest element with element at index i
            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }

    // Function to print array (same style as bubble sort)
    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 3, 2};

        selectionsort(arr);   // Sort array

        printarr(arr);        // Print sorted array
    }
}
