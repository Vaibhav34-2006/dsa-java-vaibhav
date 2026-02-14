package leetcode;

public class Leetcode_16 {

    // Function to check whether a number is power of four
    public static boolean isPowerOfFour(int n) {

        // Power of four must be positive
        if (n <= 0) return false;

        // Condition 1: n should have only one set bit (power of two)
        // Condition 2: n % 3 == 1 ensures it is power of four
        return (n & (n - 1)) == 0 && (n % 3 == 1);
    }

    public static void main(String[] args) {

        // Sample test cases
        int n1 = 16;
        int n2 = 8;
        int n3 = 1;

        // Print results
        System.out.println(n1 + " is power of four? " + isPowerOfFour(n1));
        System.out.println(n2 + " is power of four? " + isPowerOfFour(n2));
        System.out.println(n3 + " is power of four? " + isPowerOfFour(n3));
    }
}