package leetcode;

public class Leetcode_24 {

    // Function to reverse an integer with overflow check
    public static int reverse(int x) {

        int rev = 0;

        // Continue until all digits are processed
        while (x != 0) {

            int digit = x % 10;   // get last digit
            x = x / 10;          // remove last digit

            // Check for overflow before multiplying by 10
            if (rev > Integer.MAX_VALUE / 10 ||
               (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check for underflow before multiplying by 10
            if (rev < Integer.MIN_VALUE / 10 ||
               (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }

    public static void main(String[] args) {

        // Sample test cases
        int n1 = 123;
        int n2 = -123;
        int n3 = 1534236469;  // overflow case

        // Print results
        System.out.println(n1 + " -> " + reverse(n1));
        System.out.println(n2 + " -> " + reverse(n2));
        System.out.println(n3 + " -> " + reverse(n3));
    }
}