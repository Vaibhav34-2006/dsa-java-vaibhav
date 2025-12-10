package bit_manipulation;

public class Bit_10 {

    // Function to clear (make 0) the i-th bit of number n
    public static int clearithbit(int n, int i) {

        // Step 1: Create bitmask = 1 << i
        // Example: i = 1 → 1 << 1 = 0010 (binary)
        // Step 2: Apply NOT (~) to flip all bits
        // ~(0010) = 1101 (bitmask with 0 at i-th bit)
        int bitmask = ~(1 << i);

        /*
         * To clear the i-th bit:
         * We AND the number with a bitmask that has 0 at the i-th position
         * and 1s everywhere else.
         *
         * n & bitmask:
         * - If bitmask has 0 at position i → i-th bit becomes 0
         * - Other bits remain unchanged
         */
        return n & bitmask;
    }

    public static void main(String[] args) {

        // Example: clear 1st bit of 10
        // 10 in binary = 1010
        // Clear 1st bit → 1000 (binary) = 8
        System.out.println(clearithbit(10, 1));
    }
}
