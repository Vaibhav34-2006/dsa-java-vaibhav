package greedyAlgorithm;

import java.util.Arrays;

public class GreedyAlgorithm_3 {

    public static void main(String[] args) {

        // First array
        int A[] = {1, 2, 3};

        // Second array
        int B[] = {2, 1, 3};

        // Sort both arrays
        // Greedy idea: pair smallest with smallest, largest with largest
        Arrays.sort(A);
        Arrays.sort(B);

        // Variable to store minimum absolute difference sum
        int minDiff = 0;

        // Calculate sum of absolute differences of corresponding elements
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        // Print the result
        System.out.println("Min absolute diff of pairs = " + minDiff);
    }
}
