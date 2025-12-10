package bit_manipulation;

public class Bit_14 {

    // Function to check if a number is a power of two
    public static boolean ispoweroftwo(int n) {

        /*
         * A number is a power of 2 only if:
         * It has exactly ONE '1' in its binary form.
         *
         * Trick:
         * For any power of 2 → (n & (n - 1)) becomes 0
         *
         * Example:
         * n = 8  → 1000
         * n-1= 7 → 0111
         * 1000 & 0111 = 0000  → TRUE
         *
         * Note: This does NOT work for n = 0, so we must handle that.
         */
        if (n == 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        // Check if 8 is a power of two
        System.out.println(ispoweroftwo(8));  // true
    }
}
