package basics;

public class Program_54 {

    public static void main(String[] args) {

        int n = 5;   // you can change this value
        int number = 1;

        // outer loop → rows
        for (int i = 1; i <= n; i++) {

            // inner loop → print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }

            System.out.println(); // next line
        }
    }
}
