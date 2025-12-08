package arrays;

public class Array_17 {

    // Function to print matrix in spiral order
    public static void printspiral(int matrix[][]) {
        int startrow = 0;                  // starting row index
        int startcol = 0;                  // starting column index
        int endrow = matrix.length - 1;    // ending row index
        int endcol = matrix[0].length - 1; // ending column index

        // Loop until all layers are printed
        while (startrow <= endrow && startcol <= endcol) {

            //  1. Top row: left → right
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }

            //  2. Right column: top → bottom
            for (int i = startrow + 1; i <= endrow; i++) {
                System.out.print(matrix[i][endcol] + " ");
            }

            //  3. Bottom row: right → left (only if more than 1 row left)
            if (startrow < endrow) {
                for (int j = endcol - 1; j >= startcol; j--) {
                    System.out.print(matrix[endrow][j] + " ");
                }
            }

            //  4. Left column: bottom → top (only if more than 1 column left)
            if (startcol < endcol) {
                for (int i = endrow - 1; i >= startrow + 1; i--) {
                    System.out.print(matrix[i][startcol] + " ");
                }
            }

            // Move to the next inner layer
            startcol++;
            startrow++;
            endcol--;
            endrow--;
        }

        System.out.println(); // line break after spiral
    }

    public static void main(String[] args) {

        //  Correct 4x4 matrix initialization
        int matrix[][] = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                {13, 14, 15, 16 }
        };

        // Call spiral function
        printspiral(matrix);
    }

}
