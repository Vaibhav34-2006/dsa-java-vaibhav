package arrays;

public class Array_11 {

    // Function to print all subarray sums using Prefix Sum (O(n²))
    public static void printmaxsumarray(int numbers[]) {

        int currsum = 0;                         // to store current subarray sum
        int maxsum = Integer.MIN_VALUE;          // to store maximum sum

        int prefix[] = new int[numbers.length];  // prefix array

        // Step 1: Build prefix sum array
        // prefix[i] stores sum of elements from 0 to i
        prefix[0] = numbers[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        // Step 2: Generate subarrays using start and end index
        for (int i = 0; i < numbers.length; i++) {

            int start = i;   // start index

            for (int j = i; j < numbers.length; j++) {

                int end = j; // end index

                // Step 3: Compute subarray sum using prefix array
                // If start = 0 → sum = prefix[end]
                // Else → sum = prefix[end] - prefix[start - 1]
                currsum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];

                // Print each subarray sum
                System.out.println(currsum);

                // Update maximum sum
                if (currsum > maxsum) {
                    maxsum = currsum;
                }
            }

            // Print max sum found so far (optional)
            System.out.println("Max till now = " + maxsum);
        }
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, 6, 8, 10};   // input array

        printmaxsumarray(numbers);          // function call
    }
}
