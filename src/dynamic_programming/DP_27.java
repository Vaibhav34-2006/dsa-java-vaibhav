package dynamic_programming;

import java.util.Arrays;

public class DP_27 {

    // Matrix Chain Multiplication using Memoization
    // arr[] -> dimensions array
    // i, j  -> range of matrices (Ai to Aj)
    // dp[][] -> memoization table
    public static int mcmMem(int arr[], int i, int j, int dp[][]) {

        // Base case:
        // Single matrix -> no multiplication cost
        if (i == j) {
            return 0;
        }

        // If already computed, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Initialize answer with maximum value
        int ans = Integer.MAX_VALUE;

        // Try all possible partition points
        for (int k = i; k <= j - 1; k++) {

            // Cost of multiplying matrices from i to k
            int cost1 = mcmMem(arr, i, k, dp);

            // Cost of multiplying matrices from k+1 to j
            int cost2 = mcmMem(arr, k + 1, j, dp);

            // Cost of multiplying the two resulting matrices
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            // Take minimum cost
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }

        // Store result in dp table and return
        dp[i][j] = ans;
        return dp[i][j];
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;

        // Create dp table and initialize with -1
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // MCM from matrix 1 to n-1
        System.out.println(mcmMem(arr, 1, n - 1, dp));
    }
}
