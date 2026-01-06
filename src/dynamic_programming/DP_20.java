package dynamic_programming;

public class DP_20 {

    // Wildcard Pattern Matching
    // '?' → matches any single character
    // '*' → matches any sequence (including empty)
    public static boolean isMatch(String s, String p) {

        int n = s.length(); // string length
        int m = p.length(); // pattern length

        // dp[i][j] = does s[0..i-1] match p[0..j-1]
        boolean dp[][] = new boolean[n + 1][m + 1];

        // Initialization
        dp[0][0] = true; // empty string matches empty pattern

        // Non-empty string cannot match empty pattern
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        // Empty string vs pattern
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Bottom-Up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match OR pattern has '?'
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If pattern has '*'
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                // Otherwise no match
                else {
                    dp[i][j] = false;
                }
            }
        }

        // Final result
        return dp[n][m];
    }

    public static void main(String[] args) {

        String s = "baaabab";
        String p = "*****ba*****ab";

        System.out.println(isMatch(s, p));
    }
}
