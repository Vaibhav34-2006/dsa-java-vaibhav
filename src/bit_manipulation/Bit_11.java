package bit_manipulation;

public class Bit_11 {

    // -------------------------------
    // Function to SET the i-th bit
    // -------------------------------
    public static int setithbit(int n, int i) {
        int bitmask = 1 << i; 
        return n | bitmask;   // OR makes the i-th bit = 1
    }

    // -------------------------------
    // Function to CLEAR the i-th bit
    // -------------------------------
    public static int clearithbit(int n, int i) {
        int bitmask = ~(1 << i); 
        return n & bitmask;   // AND with 0 clears that bit
    }

    // -------------------------------
    // Function to UPDATE the i-th bit
    // newbit = 0 → clear bit
    // newbit = 1 → set bit
    // -------------------------------
    public static int updateithbit(int n, int i, int newbit) {

        // If newbit = 0 → clear i-th bit
        if (newbit == 0) {
            return clearithbit(n, i);
        }
        // If newbit = 1 → set i-th bit
        else {
            return setithbit(n, i);
        }
    }

    public static void main(String[] args) {

        // Example: Update 2nd bit of number 10 to 1
        // 10 = 1010 (binary)
        // Setting 2nd bit → 1110 = 14
        System.out.println(updateithbit(10, 2, 1));
    }
}
