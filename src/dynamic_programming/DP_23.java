package dynamic_programming;

public class DP_23 {

    // Function to calculate nth Catalan number using Tabulation
    public static int catalanTab(int n) {

        // dp[i] will store the ith Catalan number
        int dp[] = new int[n + 1];

        // Base cases
        dp[0] = 1;  // C0 = 1
        dp[1] = 1;  // C1 = 1

        // Build Catalan numbers from 2 to n
        for (int i = 2; i <= n; i++) {   // Ci

            // Calculate Ci using previously computed values
            for (int j = 0; j < i; j++) {

                // Catalan recurrence relation:
                // Ci = Σ (Cj * C(i-j-1))
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        // Return nth Catalan number
        return dp[n];
    }

    public static void main(String[] args) {

        // Print 5th Catalan number
        System.out.println(catalanTab(5));
    }
}
