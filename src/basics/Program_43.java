package basics;
import java.util.*;

public class Program_43 {

    // function to calculate factorial
    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    // function to calculate nCr
    public static void binomial() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter r: ");
        int r = sc.nextInt();

        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_n_r = factorial(n - r);

        int nCr = fact_n / (fact_r * fact_n_r);

        System.out.println("nCr = " + nCr);
    }
 
    public static void main(String[] args) {
        binomial();  // calling the function
    }
}
