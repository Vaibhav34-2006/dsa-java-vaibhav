package basics;
import java.util.*;

public class Program_39 {

    // Function to print Hello World
    public static void printhw() {
        System.out.println("HELLO WORLD");
    }

    // Function with PARAMETERS num1 and num2
    public static void sum(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("Sum = " + result);
    }

    public static void main(String[] args) {

        printhw();  // calling function

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // a and b are ARGUMENTS
        sum(a, b);

        sc.close();
    }
}
