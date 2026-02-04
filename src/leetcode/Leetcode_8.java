package leetcode;

public class Leetcode_8 {

    // Function to check whether a number is power of three
    public static boolean isPowerOfThree(int n) {

        // A power of three must be positive
        if (n <= 0) return false;

        // Keep dividing by 3 while divisible
        while (n % 3 == 0) {
            n = n / 3;
        }

        // If final value becomes 1, it is power of three
        return n == 1;
    }

    public static void main(String[] args) {

        // Sample test cases
        int n1 = 27;
        int n2 = 45;

        // Print results
        System.out.println(n1 + " is power of three? " + isPowerOfThree(n1));
        System.out.println(n2 + " is power of three " + isPowerOfThree(n2));
    }
}
