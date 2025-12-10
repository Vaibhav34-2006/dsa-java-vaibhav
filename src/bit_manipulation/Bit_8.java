package bit_manipulation;

public class Bit_8 {

    // Function to get the i-th bit of number n
    public static int getithbit(int n, int i) {

        // Create a bitmask by shifting 1 to the left by i positions
        // Example: i = 2 → 1 << 2 = 0100 (binary)
        int bitmask = 1 << i;

        /*
         * Perform AND operation:
         * (n & bitmask)
         * If the result is 0 → the i-th bit is 0
         * If the result is non-zero → the i-th bit is 1
         */
        if ((n & bitmask) == 0) {
            return 0;  // i-th bit is 0
        } else {
            return 1;  // i-th bit is 1
        }
    }

    public static void main(String[] args) {

        // Example: Find 2nd bit of number 10
        // 10 in binary = 1010
        // Bits (right to left): 3rd 2nd 1st 0th
        // 2nd bit = 1
        System.out.println(getithbit(10, 2));
    }
}
