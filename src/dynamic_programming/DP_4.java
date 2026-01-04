package dynamic_programming;

import java.util.Arrays;

public class DP_4 {

    // This function returns number of ways to climb n stairs
    // Using recursion + memoization (DP)
    public static int countWays(int n, int ways[]) {

        // Base case 1:
        // If n == 0, it means we reached the top exactly
        // One valid way is found
        if (n == 0) {
            return 1;
        }

        // Base case 2:
        // If n < 0, it means we crossed the steps
        // This is not a valid way
        if (n < 0) {
            return 0;
        }

        // If answer for n is already calculated and stored
        // then return it directly (avoid recalculation)
        if (ways[n] != -1) { // already calculated
            return ways[n];
        }

        // Recursive calls:
        // Count ways by taking 1 step and 2 steps
        // Store the result in ways[n]
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);

        // Return stored answer
        return ways[n];
    }

    public static void main(String[] args) {

        // Number of stairs
        int n = 5;
        // n = 3 → 3 ways
        // n = 4 → 5 ways
        // n = 5 → 8 ways

        // Array to store already calculated results
        int ways[] = new int[n + 1];

        // Fill array with -1 to indicate uncalculated values
        Arrays.fill(ways, -1);

        // Call function and print total ways
        System.out.println(countWays(n, ways));
    }
}

