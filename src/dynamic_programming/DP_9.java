package dynamic_programming;
public class DP_9 {

    // Time Complexity: O(n * sum)
    // This function checks whether a subset with given sum exists
    public static boolean targetSumSubset(int arr[], int sum) {

        // Number of elements in array
        int n = arr.length;

        // DP table
        // dp[i][j] = true if we can make sum j using first i elements
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialization:
        // If sum = 0, answer is always true (empty subset)
        // So first column is true
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                // Current element value
                int v = arr[i - 1];

                // Include case:
                // If value is less than or equal to target
                // and previous state is true
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }

                // Exclude case:
                // If sum can be made without current element
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        // Final answer:
        // Can we make 'sum' using all elements?
        return dp[n][sum];
    }

    public static void main(String[] args) {

        // Given array
        int arr[] = {4, 2, 7, 1, 3};

        // Target sum
        int sum = 20;

        // Print result
        System.out.println(targetSumSubset(arr, sum));
    }
}
