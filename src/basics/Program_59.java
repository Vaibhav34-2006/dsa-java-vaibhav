package basics;

public class Program_59 {

    // Function to print Diamond Pattern
    public static void diamond(int n) {

        // ================== 1st HALF ==================
        for (int i = 1; i <= n; i++) {

            // Print spaces (left side)
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // Print stars (odd count)
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }

        // ================== 2nd HALF ==================
        for (int i = n - 1; i >= 1; i--) {

            // Print spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 5;
        diamond(n);
    }
}
