package dynamic_programming;

public class DP_24 {

    // Function to count number of unique BSTs with n nodes
    public static int countBST(int n) {

        // dp[i] will store number of BSTs with i nodes
        int dp[] = new int[n + 1];

        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Single node tree

        // Build solution for 2 to n nodes
        for (int i = 2; i <= n; i++) {

            // Ci -> number of BSTs with i nodes
            for (int j = 0; j < i; j++) {

                // j nodes in left subtree
                int left = dp[j];

                // (i-j-1) nodes in right subtree
                int right = dp[i - j - 1];

                // Total BSTs formed with current root
                dp[i] += left * right;
            }
        }

        // Return result for n nodes
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 3;

        // Print number of unique BSTs
        System.out.println(countBST(n));
    }
}
