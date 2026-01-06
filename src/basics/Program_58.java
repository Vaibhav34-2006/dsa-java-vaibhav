package basics;

public class Program_58 {

    // Function to print Hollow Rhombus pattern
    public static void hollow_rhombus(int n) {

        // Outer loop -> number of rows
        for (int i = 1; i <= n; i++) {

            // Step 1: Print leading spaces
            // Number of spaces decreases each row
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // Step 2: Print stars and spaces (hollow rectangle)
            for (int j = 1; j <= n; j++) {

                // Print star on boundary
                // First row, last row, first column, last column
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } 
                // Inside hollow area
                else {
                    System.out.print(" ");
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 5;
        hollow_rhombus(n);
    }
}
