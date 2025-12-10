package bit_manipulation;
import java.util.*;

public class Bit_2 {

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user for first number
        System.out.println("Enter first no.:");
        int a = sc.nextInt();   // store first number

        // Ask user for second number
        System.out.println("Enter Second no.:");
        int b = sc.nextInt();   // store second number

        // Perform bitwise OR operation and print result
        // Bitwise OR (|) compares each bit:
        // If any one bit is 1 → result bit becomes 1
        System.out.println(a | b);

        
    }
}
