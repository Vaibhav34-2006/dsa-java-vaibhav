package bit_manipulation;

public class Bit_13 {

    // Function to clear bits in the range i to j
    public static int clearRangeBits(int n, int i, int j) {

        // Step 1: Create a mask with 1s before j and 1s after i
        // Example:
        // Left mask = (~0) << (j + 1)
        // Right mask = (1 << i) - 1
        // Final mask = left mask | right mask

        // Left part: 1s after j
        int left = (~0) << (j + 1);

        // Right part: 1s before i
        int right = (1 << i) - 1;

        // Final mask = left OR right
        int bitmask = left | right;

        // Clear the range by AND with mask
        return n & bitmask;
    }

    public static void main(String[] args) {

        // Example: Clear bits 1 to 3 of number 31
        // 31 = 11111 → bits 1 to 3 cleared → 10001 = 17
        System.out.println(clearRangeBits(31, 1, 3));
    }
}
