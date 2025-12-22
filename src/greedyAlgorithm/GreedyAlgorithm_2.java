package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm_2 {

    public static void main(String[] args) {

        // Values of items
        int val[] = {60, 100, 120};

        // Weights of items
        int weight[] = {10, 20, 30};

        // Capacity of knapsack
        int W = 50;

        /*
         * ratio[i][0] -> index of item
         * ratio[i][1] -> value / weight ratio
         */
        double ratio[][] = new double[val.length][2];

        // Calculate value/weight ratio for each item
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sort items by ratio in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalVal = 0;

        // Traverse from highest ratio to lowest
        for (int i = ratio.length - 1; i >= 0; i--) {

            int idx = (int) ratio[i][0];

            // If full item can be included
            if (capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];
            } 
            else {
                // Include fractional part of item
                finalVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        // Print maximum value obtained
        System.out.println("Final value = " + finalVal);
    }
}
