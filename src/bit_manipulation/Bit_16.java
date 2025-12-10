package bit_manipulation;

public class Bit_16{

    // Function to compute a^n using fast exponentiation (Binary Exponentiation)
    public static int power(int a, int n) {
        
        int result = 1;   // final answer

        // Loop until power becomes zero
        while (n > 0) {

            // If the last bit of n is 1 → multiply result by a
            if ((n & 1) != 0) {
                result = result * a;
            }

            // Square the base (a = a^2)
            a = a * a;

            // Right shift n (divide power by 2)
            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args) {

        // Example: 3^5 = 243
        System.out.println(power(3, 5));
    }
}
