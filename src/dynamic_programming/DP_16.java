package dynamic_programming;

public class DP_16 {

    // Longest Common Substring using DP (Bottom-Up)
    // Time Complexity: O(n * m)
    public static int longestCommonSubstring(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // dp[i][j] = length of longest common substring
        // ending at str1[i-1] and str2[j-1]
        int dp[][] = new int[n + 1][m + 1];

        int ans = 0; // stores maximum length found

        // Initialization:
        // If any string length is 0, substring length = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        // Bottom-Up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
                // If characters do not match
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String str1 = "ABCDE";
        String str2 = "ABGCE";

        System.out.println(longestCommonSubstring(str1, str2));
    }
}
