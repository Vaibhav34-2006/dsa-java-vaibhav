package dynamic_programming;

public class DP_8 {

    // 0/1 Knapsack using Tabulation (Bottom-Up DP)
    // Each item can be taken ONLY ONCE
    public static int knapsack01(int val[], int wt[], int W) {

        // Number of items
        int n = val.length;

        // DP table
        // dp[i][j] = maximum profit using first i items
        // with knapsack capacity j
        int dp[][] = new int[n + 1][W + 1];

        // Initialize 0th column
        // If capacity is 0, profit is always 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        // Initialize 0th row
        // If there are 0 items, profit is always 0
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill DP table
        for (int i = 1; i < n + 1; i++) {        // items loop
            for (int j = 1; j < W + 1; j++) {    // capacity loop

                // If current item weight is within capacity
                if (wt[i - 1] <= j) {   // valid case

                    // Include the item (move to previous item → 0/1 rule)
                    int include = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                    // Exclude the item
                    int exclude = dp[i - 1][j];

                    // Take maximum of include and exclude
                    dp[i][j] = Math.max(include, exclude);
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
        System.out.println(knapsack01(val, wt, W));
    }
}
