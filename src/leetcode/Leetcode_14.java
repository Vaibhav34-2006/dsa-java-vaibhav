package leetcode;

public class Leetcode_14 {

    // Function to calculate x raised to the power n
    public static double myPow(double x, int n) {

        // Use long to safely handle Integer.MIN_VALUE
        long power = n;

        // If power is negative, invert x and make power positive
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        // Fast power calculation (binary exponentiation)
        while (power > 0) {

            // If power is odd, multiply result by x
            if (power % 2 == 1) {
                result *= x;
            }

            // Square x and divide power by 2
            x *= x;
            power /= 2;
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample test cases
        System.out.println("2^10 = " + myPow(2.0, 10));
        System.out.println("2^-2 = " + myPow(2.0, -2));
        System.out.println("3^5 = " + myPow(3.0, 5));
    }
}
