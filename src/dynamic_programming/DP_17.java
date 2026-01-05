package dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;

public class DP_17 {

    // LCS function (Tabulation)
    // Finds LCS length between two integer arrays
    public static int lcs(int arr1[], int arr2[]) {

        int n = arr1.length;
        int m = arr2.length;

        // dp[i][j] = LCS length of arr1[0..i-1] and arr2[0..j-1]
        int dp[][] = new int[n + 1][m + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        // Bottom-Up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If elements are equal
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If elements are not equal
                else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    // LIS using LCS concept
    public static int lis(int arr1[]) {

        // Step 1: Store unique elements using HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        // Step 2: Copy set elements into arr2
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        // Step 3: Sort arr2 (ascending order)
        Arrays.sort(arr2);

        // Step 4: LIS = LCS(arr1, sorted unique arr2)
        return lcs(arr1, arr2);
    }

    public static void main(String[] args) {

        int arr[] = {50, 3, 10, 7, 40, 80};

        System.out.println(lis(arr));
    }
}
