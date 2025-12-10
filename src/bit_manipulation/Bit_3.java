package bit_manipulation;
import java.util.*;

public class Bit_3 {

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user for first number
        System.out.println("Enter first no.:");
        int a = sc.nextInt();   // store first number

        // Ask user for second number
        System.out.println("Enter Second no.:");
        int b = sc.nextInt();   // store second number

        // Perform bitwise XOR operation and print result
        // Bitwise XOR (^) compares each bit:
        // If bits are DIFFERENT → result bit = 1
        // If bits are SAME      → result bit = 0
        System.out.println(a ^ b);

       
    }
}
