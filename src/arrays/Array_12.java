package arrays;

public class Array_12 {

    // Kadane's Algorithm to find maximum subarray sum (O(n))
    public static void kadanes(int numbers[]) {

        int ms = Integer.MIN_VALUE;   // ms = max sum so far
        int cs = 0;                   // cs = current running sum

        // Traverse the entire array once
        for (int i = 0; i < numbers.length; i++) {

            cs = cs + numbers[i];     // add current element to running sum

            // If current sum becomes negative, reset it to 0
            // (because negative sums reduce future subarray sums)
            if (cs < 0) {
                cs = 0;
            }

            // Update maximum sum so far
            ms = Math.max(ms, cs);
        }

        // Print the maximum subarray sum
        System.out.println(ms);
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, -2, -5, 2, 4};  // input array

        kadanes(numbers);                      // function call
    }
}
