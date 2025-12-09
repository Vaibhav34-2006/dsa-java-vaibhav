package strings;
import java.util.Scanner;

public class String_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking full line input from the user (includes spaces)
        String fullName = sc.nextLine();

        // Printing the length of the string (number of characters)
        System.out.println(fullName.length());

        sc.close(); // closing scanner
    }
}
