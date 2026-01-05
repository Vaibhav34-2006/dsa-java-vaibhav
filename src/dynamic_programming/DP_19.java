package dynamic_programming;

public class DP_19 {

    // String Conversion using ONLY Insert & Delete
    public static int stringConversion(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // dp[i][j] = minimum operations to convert
        // str1[0..i-1] to str2[0..j-1]
        int dp[][] = new int[n + 1][m + 1];

        // Initialization (same as Edit Distance)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;   // delete all characters
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;   // insert all characters
        }

        // Bottom-Up DP (NO replace)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match → no operation
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If characters differ → only insert OR delete
                else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;

                    dp[i][j] = Math.min(insert, delete);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        String str1 = "pear";
        String str2 = "sea";

        System.out.println(stringConversion(str1, str2));
    }
}
