package dynamic_programming;

public class DP_10 {

    // Unbounded Knapsack using Tabulation (Bottom-Up DP)
    // You can take the same item multiple times
    public static int unboundedKnapsack(int val[], int wt[], int W) {

        // Number of items
        int n = val.length;

        // DP table
        // dp[i][j] = maximum profit using first i items with capacity j
        int dp[][] = new int[n + 1][W + 1];

        // Initialize 0th column
        // If capacity is 0, profit is 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        // Initialize 0th row
        // If no items are available, profit is 0
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill DP table
        for (int i = 1; i < n + 1; i++) {        // items loop
            for (int j = 1; j < W + 1; j++) {    // capacity loop

                // If current item weight is less than or equal to capacity
                if (wt[i - 1] <= j) {   // valid case

                    // Include the item (can include again → unbounded)
                    // i stays same
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i][j - wt[i - 1]],
                            dp[i - 1][j]
                    );
                }
                // If item weight is more than capacity
                else {   // invalid case

                    // Cannot include item, so exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer stored here
        return dp[n][W];
    }

    public static void main(String[] args) {

        // Values of items
        int val[] = {15, 14, 10, 45, 30};

        // Weights of items
        int wt[] = {2, 5, 1, 3, 4};

        // Capacity of knapsack
        int W = 7;

        // Print maximum profit
        System.out.println(unboundedKnapsack(val, wt, W));
    }
}
