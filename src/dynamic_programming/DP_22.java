package dynamic_programming;

import java.util.Arrays;

public class DP_22 {

    // Function to calculate nth Catalan number using Memoization
    public static int catalanMem(int n, int dp[]) {

        // Base case:
        // C0 = 1 and C1 = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // If result is already stored, return it
        if (dp[n] != -1) {
            return dp[n];
        }

        // Variable to store Catalan number Cn
        int ans = 0;

        // Apply Catalan recurrence relation
        // Cn = Σ Ci * C(n-i-1)
        for (int i = 0; i < n; i++) {

            // Recursive calls with memoization
            ans += catalanMem(i, dp) * catalanMem(n - i - 1, dp);
        }

        // Store result in dp array and return
        dp[n] = ans;
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 4;

        // Create dp array for memoization
        int dp[] = new int[n + 1];

        // Initialize dp array with -1
        Arrays.fill(dp, -1);

        // Print nth Catalan number
        System.out.println(catalanMem(n, dp));
    }
}
