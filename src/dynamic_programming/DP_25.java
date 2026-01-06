package dynamic_programming;

public class DP_25 {

    // Function to count number of mountain ranges using DP
    // Time Complexity: O(n^2)
    public static int mountainRanges(int n) {

        // dp[i] = number of mountain ranges using i pairs
        int dp[] = new int[n + 1];

        // Base cases
        dp[0] = 1; // empty mountain
        dp[1] = 1; // single pair

        // Build answer from 2 pairs to n pairs
        for (int i = 2; i <= n; i++) {

            // i pairs → ith Catalan number
            for (int j = 0; j < i; j++) {

                // inside pairs
                int inside = dp[j];

                // outside pairs
                int outside = dp[i - j - 1];

                // Catalan recurrence:
                // Ci += Cj * C(i-j-1)
                dp[i] += inside * outside;
            }
        }

        // Number of mountain ranges with n pairs
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 4; // Expected output = 14
        System.out.println(mountainRanges(n));
    }
}
