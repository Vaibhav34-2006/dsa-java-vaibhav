package dynamic_programming;

public class DP_14 {

    // LCS using Memoization (Top-Down DP)
    // str1 -> first string
    // str2 -> second string
    // n    -> length of str1
    // m    -> length of str2
    // dp   -> memoization table
    public static int lcs2(String str1, String str2, int n, int m, int dp[][]) {

        // Base Case:
        // If any string length becomes 0, LCS = 0
        if (n == 0 || m == 0) {
            return 0;
        }

        // If value already calculated, return it
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // If last characters are same
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcs2(str1, str2, n - 1, m - 1, dp) + 1;
        }
        // If last characters are different
        else {
            int ans1 = lcs2(str1, str2, n - 1, m, dp);
            int ans2 = lcs2(str1, str2, n, m - 1, dp);

            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {

        String str1 = "abcdge";
        String str2 = "abedg";   // LCS = "abdg", length = 4

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        // Initialization of DP array with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcs2(str1, str2, n, m, dp));
    }
}
