package basics;

public class Program_51 {

    public static void hollow_rectangle(int totrows, int totcols) {
        // outer loop
        for (int i = 1; i <= totrows; i++) {

            // inner loop
            for (int j = 1; j <= totcols; j++) {

                // boundary condition
                if (i == 1 || i == totrows || j == 1 || j == totcols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");  // space inside
                }
            }
            System.out.println();  // next line after each row
        }
    }

    public static void main(String[] args) {
        hollow_rectangle(4, 5);
    }
}
