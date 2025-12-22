package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm_4 {

    public static void main(String[] args) {

        // Given pairs (start, end)
        int pairs[][] = {
                {5, 24},
                {39, 60},
                {5, 28},
                {27, 40},
                {50, 90}
        };

        // Sort pairs based on their ending time (second value)
        // Greedy idea: always choose the pair with the earliest ending
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        // At least one pair can always be selected
        int chainLen = 1;

        // End of the last selected pair
        int chainEnd = pairs[0][1];

        // Traverse remaining pairs
        for (int i = 1; i < pairs.length; i++) {

            // If current pair can be chained
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        // Print maximum length of chain
        System.out.println("Max length of chain = " + chainLen);
    }
}
