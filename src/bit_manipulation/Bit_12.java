package bit_manipulation;

public class Bit_12 {

    // Function to clear (make 0) the last i bits of number n
    public static int clearlastibits(int n, int i) {

        // (~0) gives all 1s in binary (111111...111)
        // Left shifting by i gives a mask with:
        // → 1s from i-th bit upward
        // → 0s in the last i bits
        //
        // Example: i = 2
        // (~0) = 111111...
        // (~0) << 2 = ...11111100
        int bitmask = (~0) << i;

        // AND with bitmask clears the last i bits of n
        return n & bitmask;
    }

    public static void main(String[] args) {

        // Example: clear last 2 bits of 15
        // 15 = 1111 (binary)
        // Clear last 2 bits → 1100 (binary) = 12
        System.out.println(clearlastibits(15, 2));
    }
}
