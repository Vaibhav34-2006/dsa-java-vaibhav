package dynamic_programming;

public class DP_11 {

    // Function to count number of ways to make given sum using coins[]
    public static int coinChange(int coins[], int sum) {

        int n = coins.length;

        // dp[i][j] = number of ways to make sum j using first i coins
        int dp[][] = new int[n + 1][sum + 1];

        // Base Case 1:
        // If sum = 0, there is exactly 1 way (choose no coins)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Base Case 2:
        // If no coins are available and sum > 0, ways = 0
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        // Fill the DP table (Tabulation)
        // Time Complexity: O(n * sum)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                // If current coin value is less than or equal to current sum
                if (coins[i - 1] <= j) {

                    // Include the coin + Exclude the coin
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];

                } else {
                    // Exclude the coin
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer will be stored here
        return dp[n][sum];
    }

    public static void main(String[] args) {

        int coins[] = {1, 2, 3};
        int sum = 4; // Expected answer = 4

        System.out.println(coinChange(coins, sum));
    }
}
