package backtracking;

public class Backtracking_1 {

    // Function to change array using backtracking
    public static void changeArr(int arr[], int i, int val) {

        //  Base case: when index reaches array length
        if (i == arr.length) {
            printArr(arr);   // print array when filled
            return;
        }

        //  Recursion: assign value at current index
        arr[i] = val;

        // Move to next index with increased value
        changeArr(arr, i + 1, val + 1);

        // 🔹 Backtracking step
        // Undo the change while returning back
        arr[i] = arr[i] - 2;
    }

    // Function to print array elements
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = new int[5];

        // Call backtracking function
        changeArr(arr, 0, 1);

        // Final array after backtracking
        printArr(arr);
    }
}
