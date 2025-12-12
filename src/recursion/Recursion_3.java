package recursion;

public class Recursion_3 {

    // Function to calculate factorial of n using recursion
    public static int fact(int n) {

        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive call: calculate factorial of (n-1)
        int fnm1 = fact(n - 1);  // stores (n-1)!

        // Work: multiply n * (n-1)!
        int fn = n * fnm1;

        return fn;  // return n!
    }

    public static void main(String[] args) {

        int n = 5;

        // Call function and print result
        int ans = fact(n);
        System.out.println("Factorial = " + ans);
    }
}
