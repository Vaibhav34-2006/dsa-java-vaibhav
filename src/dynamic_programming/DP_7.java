package dynamic_programming;

public class DP_7 {

    // Memoization function for 0/1 Knapsack
    // val[] = values of items
    // wt[]  = weights of items
    // W     = remaining capacity
    // n     = number of items
    // dp[][] = DP table to store already calculated answers
    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {

        // Base case:
        // If no capacity left OR no items left
        // then maximum value is 0
        if (W == 0 || n == 0) {
            return 0;
        }

        // If result is already calculated
        // return it directly (memoization)
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // If weight of current item is within capacity
        if (wt[n - 1] <= W) {   // valid case

            // Include current item
            int ans1 = val[n - 1] 
                       + knapsack(val, wt, W - wt[n - 1], n - 1, dp);

            // Exclude current item
            int ans2 = knapsack(val, wt, W, n - 1, dp);

            // Store maximum of both choices
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        // If weight is more than capacity
        // cannot include the item
        else {   // not valid
            dp[n][W] = knapsack(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args) {

        // Values of items
        int val[] = {15, 14, 10, 45, 30};

        // Weights of items
        int wt[] = {2, 5, 1, 3, 4};

        // Capacity of knapsack
        int W = 7;

        // DP table of size (items+1) x (capacity+1)
        int dp[][] = new int[val.length + 1][W + 1];

        // Initialize DP table with -1
        // -1 means value not calculated yet
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // Call knapsack function and print result
        System.out.println(knapsack(val, wt, W, val.length, dp));
    }
}
