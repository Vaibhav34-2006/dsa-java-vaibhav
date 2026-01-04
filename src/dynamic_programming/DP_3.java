package dynamic_programming;

public class DP_3 {

    // This function returns number of ways to climb n stairs
    // You can climb either 1 step or 2 steps at a time
    public static int countWays(int n) {

        // Base case 1:
        // If n == 0, it means we reached the top successfully
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

        // Recursive case:
        // Count ways by taking:
        // 1 step + 2 steps
        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {

        // Number of stairs
        int n = 5; 
        // n=3 → 3 ways
        // n=4 → 5 ways
        // n=5 → 8 ways

        // Print total number of ways to climb stairs
        System.out.println(countWays(n));
    }
}
