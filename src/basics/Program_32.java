package basics;
import java.util.*;

public class Program_32 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int count = 0;   // to count how many numbers divide n

        if (n <= 1) {
            System.out.println("Not Prime");
            return;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;      // divisor found
                break;        // no need to continue
            }
        }

        if (count == 0) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not Prime");
        }
    }
}
