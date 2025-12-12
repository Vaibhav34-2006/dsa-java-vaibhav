package recursion;

public class Recursion_10 {

    // Function to compute x^n in O(log n) time
    public static int power(int x, int n) {

        // Base case
        if (n == 0) {
            return 1;
        }

        // Recursive call: compute x^(n/2)
        int halfPower = power(x, n / 2);

        // If n is even → x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return halfPower * halfPower;
        }
        // If n is odd → x^n = x * (x^(n/2))^2
        else {
            return x * halfPower * halfPower;
        }
    }

    public static void main(String[] args) {

        int x = 2;
        int n = 10;

        System.out.println(power(x, n));   // Output: 1024
    }
}
