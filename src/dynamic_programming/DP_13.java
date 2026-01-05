package dynamic_programming;

public class DP_13 {

    // Recursive function to find LCS length
    // str1 -> first string
    // str2 -> second string
    // n    -> length of str1
    // m    -> length of str2
    public static int lcs(String str1, String str2, int n, int m) {

        // Base Case:
        // If any string length becomes 0, LCS = 0
        if (n == 0 || m == 0) {
            return 0;
        }

        // If last characters are same
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1) + 1;
        }
        // If last characters are different
        else {
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);

            return Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {

        String str1 = "abcdge";
        String str2 = "abedg";   // LCS = "abdg", length = 4

        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}
