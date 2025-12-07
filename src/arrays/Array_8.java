package arrays;

public class Array_8 {

    // Function to print all pairs in an array
    public static void printpairs(int numbers[]) {

        // Outer loop → picks each element one by one
        for (int i = 0; i < numbers.length; i++) {

            int current = numbers[i];   // current element

            // Inner loop → pairs current with every element to its right
            for (int j = i + 1; j < numbers.length; j++) {

                // Print pair (current, next element)
                System.out.println("(" + current + ", " + numbers[j] + ")");
            }
        }

        System.out.println();  // blank line after printing all pairs
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, 6, 8, 10};  // input array

        printpairs(numbers);  // function call
    }
}
