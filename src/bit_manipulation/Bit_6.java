package bit_manipulation;
import java.util.*;

public class Bit_6{

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user for the main number
        System.out.println("Enter a number:");
        int a = sc.nextInt();   // number to shift

        // Ask user for how many positions to shift
        System.out.println("Enter shift value:");
        int b = sc.nextInt();   // number of bits to shift

        // Perform right shift operation and print result
        // Right Shift (>>) moves bits to the right by b positions:
        // It is equal to: a / (2^b)    (integer division)
        System.out.println(a >> b);

        sc.close(); // close scanner
    }
}
