package dynamic_programming;

public class DP_8 {

    // Function to print the DP table
    public static void print(int dp[][]) {

        // Loop through rows
        for (int i = 0; i < dp.length; i++) {

            // Loop through columns
            for (int j = 0; j < dp[0].length; j++) {

                // Print each cell with space
                System.out.print(dp[i][j] + " ");
            }

            // Move to next line after each row
            System.out.println();
        }

        // Extra line for readability
        System.out.println();
    }

    // 0/1 Knapsack using TABULATION
    public static int knapsackTab(int val[], int wt[], int W) {

        // Number of items
        int n = val.length;

        // DP table where
        // dp[i][j] = max profit using first i items with capacity j
        int dp[][] = new int[n + 1][W + 1];

        // Initialize 0th column
        // If capacity is 0, profit = 0
        for (int i = 0; i < dp.length; i++) { // 0th column
            dp[i][0] = 0;
        }

        // Initialize 0th row
        // If no items, profit = 0
        for (int j = 0; j < dp[0].length; j++) { // 0th row
            dp[0][j] = 0;
        }

        // Fill DP table
        for (int i = 1; i < n + 1; i++) {          // items loop
            for (int j = 1; j < W + 1; j++) {      // capacity loop

                // Value of ith item
                int v = val[i - 1];

                // Weight of ith item
                int w = wt[i - 1];

                // If item weight is within capacity
                if (w <= j) { // valid

                    // Include item
                    int incProfit = v + dp[i - 1][j - w];

                    // Exclude item
                    int excProfit = dp[i - 1][j];

                    // Store maximum profit
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                // If item weight is more than capacity
                else { // invalid

                    // Only exclude item
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        // Print DP table (as in image)
        print(dp);

        // Final answer stored here
        return dp[n][W];
    }

    public static void main(String[] args) {

        // Values array
        int val[] = {15, 14, 10, 45, 30};

        // Weights array
        int wt[] = {2, 5, 1, 3, 4};

        // Knapsack capacity
        int W = 7;

        // Call tabulation function
        System.out.println(knapsackTab(val, wt, W));
    }
}
