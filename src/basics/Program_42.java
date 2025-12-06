package basics;
import java.util.*;

public class Program_42 {

    public static void fac() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int f = 1;

        for (int i = 1; i <= n; i++) {
            f *= i;
        }

        System.out.println("Factorial = " + f);  // printing here
    }

    public static void main(String[] args) {
        fac();   // just call the function
    }
}
