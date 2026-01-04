package dynamic_programming;

public class DP_6 {

    // Recursive function to solve 0/1 Knapsack problem
    // val[] = values of items
    // wt[]  = weights of items
    // W     = remaining capacity of knapsack
    // n     = number of items available
    public static int knapsack(int val[], int wt[], int W, int n) {

        // Base case:
        // If capacity becomes 0 OR no items left
        // then maximum value is 0
        if (W == 0 || n == 0) {
            return 0;
        }

        // If weight of current item is less than or equal to capacity
        // then we have two choices: include or exclude
        if (wt[n - 1] <= W) {   // valid case

            // Include the current item
            // Add its value and reduce capacity
            int ans1 = val[n - 1] 
                       + knapsack(val, wt, W - wt[n - 1], n - 1);

            // Exclude the current item
            // Move to next item without changing capacity
            int ans2 = knapsack(val, wt, W, n - 1);

            // Return maximum of include and exclude
            return Math.max(ans1, ans2);
        }
        // If weight of current item is more than capacity
        // then we cannot include it
        else {   // not valid
            return knapsack(val, wt, W, n - 1);
        }
    }

    public static void main(String[] args) {

        // Values of items
        int val[] = {15, 14, 10, 45, 30};

        // Weights of items
        int wt[] = {2, 5, 1, 3, 4};

        // Capacity of knapsack
        int W = 7;

        // Call knapsack function
        // val.length = total number of items
        System.out.println(knapsack(val, wt, W, val.length));
    }
}
