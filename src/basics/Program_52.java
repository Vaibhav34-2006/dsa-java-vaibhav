package basics;

public class Program_52 {

    public static void inverted_rotated_halfpyramid(int n) {

        // outer loop → rows
        for (int i = 1; i <= n; i++) {

            // print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); 
            }

            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        inverted_rotated_halfpyramid(4);
    }
}
