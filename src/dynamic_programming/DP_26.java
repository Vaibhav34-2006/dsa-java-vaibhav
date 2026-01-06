package dynamic_programming;

public class DP_26 {

    // Matrix Chain Multiplication using Recursion
    public static int mcm(int arr[], int i, int j) {

        // Base case:
        // Only one matrix → no multiplication cost
        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        // Try all possible partitions
        for (int k = i; k <= j - 1; k++) {

            // Cost of multiplying matrices from i to k
            int cost1 = mcm(arr, i, k);

            // Cost of multiplying matrices from k+1 to j
            int cost2 = mcm(arr, k + 1, j);

            // Cost of multiplying the two resulting matrices
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            // Total cost for this partition
            int finalCost = cost1 + cost2 + cost3;

            // Take minimum
            ans = Math.min(ans, finalCost);
        }

        // Return minimum cost
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 3}; // matrix dimensions
        int n = arr.length;

        // MCM starts from matrix 1 to n-1
        System.out.println(mcm(arr, 1, n - 1));
    }
}
