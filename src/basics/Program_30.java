package basics;
import java.util.*;

public class Program_30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter your no.");
            int n = sc.nextInt();

            if (n % 10 == 0) {
                break;  // stop if last digit is 0
            }

            System.out.println(n);

        } while (true);  // infinite loop until break
    }
}
