package dynamic_programming;

public class DP_1 {

    // This function calculates the nth Fibonacci number
    // using Dynamic Programming (Memoization)
    public static int fib(int n, int f[]) {

        // Base case:
        // If n is 0 or 1, Fibonacci value is n itself
        if (n == 0 || n == 1) {
            return n;
        }

        // If Fibonacci value for n is already stored in array
        // then return it directly (no need to calculate again)
        if (f[n] != 0) {
            return f[n];
        }

        // If value is not calculated yet:
        // calculate fib(n-1) + fib(n-2)
        // and store it in array f[n]
        f[n] = fib(n - 1, f) + fib(n - 2, f);

        // Return the stored Fibonacci value
        return f[n];
    }

    public static void main(String[] args) {

        // Number whose Fibonacci value we want
        int n = 5;

        // DP array to store Fibonacci values
        // Initially all values are 0
        // Size is n+1 because index goes from 0 to n
        int f[] = new int[n + 1];

        // Call Fibonacci function and print result
        System.out.println(fib(n, f));
    }
}
