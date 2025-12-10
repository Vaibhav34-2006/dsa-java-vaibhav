package bit_manipulation;

public class Bit_15 {

    // Function to count number of set bits (1s) in binary form of n
    public static int countset(int n) {

        int count = 0;  // will store total number of 1-bits

        // Loop runs until n becomes 0
        while (n > 0) {

            // Check last bit of n
            // (n & 1) gives 1 if last bit is 1, otherwise 0
            if ((n & 1) != 0) {
                count++;  // increment count when last bit is 1
            }

            // Right shift n by 1 to check the next bit
            n = n >> 1;
        }

        return count;  // return total number of 1s
    }

    public static void main(String[] args) {

        // Example: count set bits in 13 (1101)
        // Should output 3
        System.out.println(countset(13));
    }
}
