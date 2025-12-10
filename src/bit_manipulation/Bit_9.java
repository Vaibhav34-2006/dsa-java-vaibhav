package bit_manipulation;

public class Bit_9 {

    // Function to set the i-th bit of number n
    public static int setithbit(int n, int i) {

        // Create bitmask by shifting 1 to the left by i positions
        // Example: i = 2 → 1 << 2 = 0100 (binary)
        int bitmask = 1 << i;

        /*
         * To set the i-th bit, we perform OR operation:
         * n | bitmask
         *
         * OR Rule:
         * If any bit is 1 → result bit becomes 1
         *
         * So even if n's i-th bit is 0, OR will make it 1.
         */
        return n | bitmask;
    }

    public static void main(String[] args) {

        System.out.println(setithbit(5, 2));
    }
}
