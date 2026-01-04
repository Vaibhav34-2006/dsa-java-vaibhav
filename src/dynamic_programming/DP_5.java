package dynamic_programming;

public class DP_5 {

    // This function calculates number of ways to climb stairs
    // using Tabulation (Bottom-Up Dynamic Programming)
    public static int countWaysTab(int n) {

        // DP array where dp[i] stores number of ways to reach step i
        int dp[] = new int[n + 1];

        // Base case:
        // There is 1 way to stay at step 0 (do nothing)
        dp[0] = 1;

        // Tabulation loop:
        // Build solution from 1 to n
        for (int i = 1; i <= n; i++) {

            // If we are at step 1
            // We can only come from step 0
            if (i == 1) {
                dp[i] = dp[i - 1];
            }
            // For steps >= 2
            // We can come from (i-1) or (i-2)
            else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        // dp[n] contains total number of ways
        return dp[n];
    }

    public static void main(String[] args) {

        // Number of stairs
        int n = 5;
        // n = 3 → 3 ways
        // n = 4 → 5 ways
        // n = 5 → 8 ways

        // Call tabulation function and print result
        System.out.println(countWaysTab(n));
    }
}
