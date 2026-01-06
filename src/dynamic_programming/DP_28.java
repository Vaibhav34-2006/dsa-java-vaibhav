package dynamic_programming;

public class DP_28 {

    // Matrix Chain Multiplication using Tabulation (Bottom-Up DP)
    public static int mcmTab(int arr[]) {

        int n = arr.length;

        // dp[i][j] = minimum cost to multiply matrices from Ai to Aj
        int dp[][] = new int[n][n];

        // Initialization:
        // Single matrix cost = 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // len = chain length
        for (int len = 2; len <= n - 1; len++) {

            for (int i = 1; i <= n - len; i++) {

                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible partitions
                for (int k = i; k <= j - 1; k++) {

                    // Cost of left subproblem
                    int cost1 = dp[i][k];

                    // Cost of right subproblem
                    int cost2 = dp[k + 1][j];

                    // Cost of multiplying two resulting matrices
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    // Minimum cost
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }

        // Final answer
        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 3};
        System.out.println(mcmTab(arr));
    }
}
