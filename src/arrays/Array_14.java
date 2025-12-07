package arrays;

public class Array_14 {

    // Function to return the maximum profit
    public static int maxProfit(int prices[]) {

        int buyPrice = Integer.MAX_VALUE;  // store the minimum price so far
        int maxProfit = 0;                 // store the maximum profit

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {

            // If current price is less than the buyPrice → update buyPrice
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            // Else calculate today's profit and update maxProfit
            else {
                int profit = prices[i] - buyPrice;  // sell today
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit; // if no profit → will return 0
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum Profit = " + maxProfit(prices));
    }
}
