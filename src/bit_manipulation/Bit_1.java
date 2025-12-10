package bit_manipulation;
import java.util.*;

public class Bit_1 {

    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the first number
        System.out.println("Enter first no.:");
        int a = sc.nextInt();   // store first number

        // Ask user to enter the second number
        System.out.println("Enter Second no.:");
        int b = sc.nextInt();   // store second number

        // Perform bitwise AND operation and print the result
        // Bitwise AND (&) compares each bit of a and b:
        // If both bits are 1 → result bit is 1, otherwise 0
        System.out.println(a & b);


    }
}
