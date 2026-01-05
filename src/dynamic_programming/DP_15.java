package dynamic_programming;

public class DP_15 {

    // LCS using Tabulation (Bottom-Up DP)
    // str1 -> first string
    // str2 -> second string
    public static int lcsTab(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // dp[i][j] = LCS length of str1[0..i-1] and str2[0..j-1]
        int dp[][] = new int[n + 1][m + 1];

        // Initialization:
        // If any string length is 0, LCS = 0
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If characters do not match
                else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        // Final answer
        return dp[n][m];
    }

    public static void main(String[] args) {

        String str1 = "abcdge";
        String str2 = "abedg";   // LCS = "abdg", length = 4

        System.out.println(lcsTab(str1, str2));
    }
}
