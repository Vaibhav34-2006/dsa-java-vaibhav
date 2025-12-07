package arrays;

public class Array_9 {

    // Function to print all subarrays of the array
    public static void printsubarrays(int numbers[]) {

        // Outer loop → selects starting index of subarray
        for (int i = 0; i < numbers.length; i++) {

            int start = i;   // start index of subarray

            // Middle loop → selects ending index of subarray
            for (int j = i; j < numbers.length; j++) {

                int end = j; // end index of subarray

                // Inner loop → prints elements from start to end
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " ");
                }

                System.out.println(); // new line after each subarray
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, 6, 8, 10};  // array input

        printsubarrays(numbers);           // function call
    }
}
