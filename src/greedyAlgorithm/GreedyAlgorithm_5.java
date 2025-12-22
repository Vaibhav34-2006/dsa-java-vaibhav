package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm_5 {

    public static void main(String[] args) {

        // Available coin denominations (Indian currency)
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Sort coins in descending order
        Arrays.sort(coins, Comparator.reverseOrder());

        // Amount for which minimum coins are required
        int amount = 590;

        // Counter for number of coins used
        int countOfCoins = 0;

        // List to store coins used
        ArrayList<Integer> usedCoins = new ArrayList<>();

        // Greedy approach: pick the largest coin first
        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= amount) {
                amount -= coins[i];        // Reduce amount
                usedCoins.add(coins[i]);   // Store coin
                countOfCoins++;            // Increment count
            }
        }

        // Output
        System.out.println("Total (min) coins used = " + countOfCoins);
        System.out.print("Coins used: ");
        for (int coin : usedCoins) {
            System.out.print(coin + " ");
        }
    }
}
