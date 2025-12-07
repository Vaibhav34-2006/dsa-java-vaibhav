package arrays;

public class Array_10 {

    // Function to print all subarray sums and find maximum sum
    public static void printmaxsumarray(int numbers[]) {

        int currsum = 0;                      // stores sum of current subarray
        int maxsum = Integer.MIN_VALUE;       // stores maximum sum found so far

        // Outer loop → selects starting index of subarray
        for (int i = 0; i < numbers.length; i++) {

            int start = i;                    // start index

            // Middle loop → selects ending index of subarray
            for (int j = i; j < numbers.length; j++) {

                int end = j;                  // end index
                currsum = 0;                  // reset current sum for new subarray

                // Inner loop → calculate sum from start to end
                for (int k = start; k <= end; k++) {
                    currsum += numbers[k];    // adding each element
                }

                // Print each subarray sum
                System.out.println(currsum);

                // Update maxsum if current subarray sum is greater
                if (currsum > maxsum) {
                    maxsum = currsum;
                }
            }

            // Print max sum found so far (optional)
            System.out.println("Max till now = " + maxsum);
        }
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, 6, 8, 10};      // input array

        printmaxsumarray(numbers);             // function call
    }
}
