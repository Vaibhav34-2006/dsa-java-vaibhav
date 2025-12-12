package recursion;

public class Recursion_11{

    // Function to count number of ways to tile a 2 x n floor
    public static int tilingProblem(int n) {

        // Base cases:
        // If floor size is 0 or 1 → only 1 way to place tiles
        if (n == 0 || n == 1) {
            return 1;
        }

        // ---- WORK (Recursion Choices) ----

        // Choice 1: Place tile vertically
        // After placing a vertical tile, remaining floor = 2 x (n-1)
        int fnm1 = tilingProblem(n - 1);

        // Choice 2: Place two horizontal tiles
        // After placing horizontal tiles, remaining floor = 2 x (n-2)
        int fnm2 = tilingProblem(n - 2);

        // Total ways = vertical ways + horizontal ways
        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    public static void main(String[] args) {

        int n = 5;  // floor size 2 x 5

        System.out.println(tilingProblem(n));  // Output: 8
    }
}
