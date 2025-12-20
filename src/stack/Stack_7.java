package stack;

import java.util.Stack;

public class Stack_7 {

    // Method to calculate stock span for each day
    public static void stockSpan(int stocks[], int span[]) {

        // Stack to store indices of stock prices
        Stack<Integer> s = new Stack<>();

        // Span of first day is always 1
        span[0] = 1;

        // Push index of first day into stack
        s.push(0);

        // Loop through remaining days
        for (int i = 1; i < stocks.length; i++) {

            // Current day's stock price
            int currPrice = stocks[i];

            // Pop elements from stack while current price is higher
            // than the price at index stored at top of stack
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            // If stack becomes empty, current price is highest so far
            if (s.isEmpty()) {
                span[i] = i + 1;
            } 
            // Else calculate span using previous higher price index
            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            // Push current index into stack
            s.push(i);
        }
    }

    public static void main(String[] args) {

        // Array of stock prices
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};

        // Array to store span values
        int span[] = new int[stocks.length];

        // Call stock span function
        stockSpan(stocks, span);

        // Print stock span values
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " ");
        }
    }
}
