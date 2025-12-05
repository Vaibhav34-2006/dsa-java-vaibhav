package basics;
import java.util.*;

public class Program_26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // size of the square

        for (int i = 1; i <= n; i++) {           // rows
            for (int j = 1; j <= n; j++) {       // columns
                System.out.print("*");
            }
            System.out.println(); // move to next line
        }
    }
}
