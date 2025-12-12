package recursion;

public class Recursion_5 {

    // Function to return nth Fibonacci number using recursion
    public static int fib(int n) {

        // Base cases:
        // Fibonacci of 0 = 0
        // Fibonacci of 1 = 1
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursive call to get (n-1)th term
        int fnm1 = fib(n - 1);

        // Recursive call to get (n-2)th term
        int fnm2 = fib(n - 2);

        // Add previous two Fibonacci numbers
        int fn = fnm1 + fnm2;

        return fn;
    }

    public static void main(String[] args) {

        int n = 5;

        // Print the nth Fibonacci number
        System.out.println(fib(n));  // Output: 5
    }
}
