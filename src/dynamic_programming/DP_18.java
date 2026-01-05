package dynamic_programming;

public class DP_18 {

    // Edit Distance using DP (Tabulation / Bottom-Up)
    // Operations allowed: Insert, Delete, Replace
    public static int editDistance(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // dp[i][j] = minimum operations to convert
        // str1[0..i-1] to str2[0..j-1]
        int dp[][] = new int[n + 1][m + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                // If first string is empty → insert all characters of str2
                if (i == 0) {
                    dp[i][j] = j;
                }

                // If second string is empty → delete all characters of str1
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // Bottom-Up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters are same → no operation needed
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If characters are different
                else {
                    int add = dp[i][j - 1] + 1;     // Insert
                    int del = dp[i - 1][j] + 1;     // Delete
                    int rep = dp[i - 1][j - 1] + 1; // Replace

                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        String word1 = "intention";
        String word2 = "execution";

        System.out.println(editDistance(word1, word2));
    }
}
