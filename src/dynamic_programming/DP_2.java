package dynamic_programming;

public class DP_2 {

    // Function to calculate Fibonacci using Tabulation (Bottom-Up DP)
    public static int fibTabulation(int n) {

        // Create DP array of size n+1
        // dp[i] will store the ith Fibonacci number
        int dp[] = new int[n + 1];

        // Base case:
        // Fibonacci of 0 is 0
        dp[0] = 0;

        // Fibonacci of 1 is 1
        dp[1] = 1;

        // Fill the dp array from 2 to n
        // Each value depends on previous two values
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // dp[n] contains the final Fibonacci answer
        return dp[n]; // ans
    }

    public static void main(String[] args) {

        // Number whose Fibonacci value we want
        int n = 5;

        // Call tabulation method and print result
        System.out.println(fibTabulation(n));
    }
}
