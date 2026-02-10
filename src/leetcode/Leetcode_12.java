package leetcode;

import java.util.Arrays;

public class Leetcode_12 {

    // Function to find minimum number of taps needed
    public static int minTaps(int n, int[] ranges) {

        // maxReach[i] = farthest right point that can be covered
        // starting from position i
        int[] maxReach = new int[n + 1];

        // Convert tap ranges into interval coverage
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            maxReach[left] = Math.max(maxReach[left], right);
        }

        int taps = 0;       // number of taps opened
        int currEnd = 0;    // end of current covered area
        int farthest = 0;   // farthest area reachable so far

        // Greedy scan from left to right
        for (int i = 0; i <= n; i++) {

            // If we cannot move forward, watering is impossible
            if (i > farthest) return -1;

            // When current coverage ends, open a new tap
            if (i > currEnd) {
                taps++;
                currEnd = farthest;
            }

            // Extend farthest reachable position
            farthest = Math.max(farthest, maxReach[i]);
        }

        return taps;
    }

    public static void main(String[] args) {

        // Sample test case 1
        int n1 = 5;
        int[] ranges1 = {3, 4, 1, 1, 0, 0};

        // Sample test case 2
        int n2 = 3;
        int[] ranges2 = {0, 0, 0, 0};

        // Print results
        System.out.println("Result 1: " + minTaps(n1, ranges1));
        System.out.println("Result 2: " + minTaps(n2, ranges2));
    }
}
