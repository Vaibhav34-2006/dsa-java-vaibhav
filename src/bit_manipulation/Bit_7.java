package bit_manipulation;

public class Bit_7 {

    // Function to check odd or even using bit manipulation
    public static void oddoreven(int n) {

        // Bitmask = 1 (binary 0001)
        // This helps us check the last bit of the number
        int bitmask = 1;

        /*
         * (n & bitmask) checks the LAST BIT of n:
         * If last bit = 0 → number is EVEN
         * If last bit = 1 → number is ODD
         *
         * VERY IMPORTANT:
         * We MUST use parentheses: (n & bitmask) == 0
         */
        if ((n & bitmask) == 0) {
            System.out.println("Even number");   // even
        } else {
            System.out.println("Odd number");    // odd
        }
    }

    public static void main(String[] args) {

        // Check whether 3 is odd or even
        oddoreven(3);
    }
}
