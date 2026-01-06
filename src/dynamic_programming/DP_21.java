package dynamic_programming;

public class DP_21 {

    // Function to calculate nth Catalan number using recursion
    public static int catalanRec(int n) {

        // Base case:
        // If n is 0 or 1, Catalan number is 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Variable to store Catalan number Cn
        int ans = 0;

        // Apply Catalan recursive formula:
        // Cn = Σ (Ci * C(n-i-1)) for i = 0 to n-1
        for (int i = 0; i <= n - 1; i++) {

            // Recursively calculate left and right subproblems
            ans += catalanRec(i) * catalanRec(n - i - 1);
        }

        // Return the final Catalan number
        return ans;
    }

    public static void main(String[] args) {

        // Value of n
        int n = 4;

        // Print nth Catalan number
        System.out.println(catalanRec(n));
    }
}
