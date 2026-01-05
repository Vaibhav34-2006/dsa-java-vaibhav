package dynamic_programming;

public class DP_12 {

    // Rod Cutting Problem using DP (Unbounded Knapsack)
    // length[] -> piece lengths
    // price[]  -> price of each piece
    // totRod   -> total rod length
    public static int rodCutting(int length[], int price[], int totRod) {

        int n = price.length;

        // dp[i][j] = maximum profit using first i pieces for rod length j
        int dp[][] = new int[n + 1][totRod + 1];

        // Base Case:
        // If no pieces OR rod length is 0, profit = 0
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totRod; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Fill DP table
        // Time Complexity: O(n * totRod)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totRod; j++) {

                // Valid case: current piece length can fit
                if (length[i - 1] <= j) {

                    // Include piece (unbounded) OR exclude piece
                    dp[i][j] = Math.max(
                            price[i - 1] + dp[i][j - length[i - 1]],
                            dp[i - 1][j]
                    );

                } else {
                    // Invalid case: cannot include piece
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer
        return dp[n][totRod];
    }

    public static void main(String[] args) {

        int length[] = {1, 2, 3, 4, 5, 6, 7, 8}; // piece lengths
        int price[]  = {1, 5, 8, 9, 10, 17, 17, 20};
        int totRod = 8;

        System.out.println(rodCutting(length, price, totRod));
    }
}
