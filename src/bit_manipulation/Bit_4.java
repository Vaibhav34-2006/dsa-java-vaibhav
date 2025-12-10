package bit_manipulation;
import java.util.*;

public class Bit_4 {

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user for the number
        System.out.println("Enter a number:");
        int a = sc.nextInt();   // store the number

        // Perform bitwise NOT operation and print result
        // Bitwise NOT (~) flips every bit in the number:
        // 1 becomes 0, and 0 becomes 1
        System.out.println(~a);

        sc.close(); // close scanner
    }
}
