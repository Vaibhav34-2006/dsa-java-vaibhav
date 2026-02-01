package leetcode;

public class Leetcode_5 {

    // Function to check whether a number is power of two
    public static boolean isPowerOfTwo(int n) {

        // A power of two must be positive
        if (n <= 0) return false;

        // If n has only one set bit in binary representation,
        // then n & (n - 1) will become 0
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        // Sample test cases
        int n1 = 16;
        int n2 = 18;

        // Test the function
        System.out.println(n1 + " is power of two? " + isPowerOfTwo(n1));
        System.out.println(n2 + " is power of two? " + isPowerOfTwo(n2));
    }
}
