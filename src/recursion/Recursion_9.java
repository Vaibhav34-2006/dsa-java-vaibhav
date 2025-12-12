package recursion;

public class Recursion_9 {

    // Function to calculate x^n using recursion
    public static int power(int x, int n) {

        // Base case: any number raised to power 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive call: compute x^(n-1)
        int xnm1 = power(x, n - 1);

        // Work: multiply x with x^(n-1)
        int xn = x * xnm1;

        return xn; // return final answer
    }

    public static void main(String[] args) {

        int x = 2;
        int n = 5;

        // Print result: 2^5 = 32
        System.out.println(power(x, n));
    }
}
