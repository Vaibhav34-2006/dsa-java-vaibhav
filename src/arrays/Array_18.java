package arrays;

public class Array_18 {

    // Function to calculate sum of both diagonals
    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        int n = matrix.length;       // number of rows (also columns for square matrix)

        for (int i = 0; i < n; i++) {

            // 1️⃣ Primary diagonal: (i, i)
            sum += matrix[i][i];

            // 2️⃣ Secondary diagonal: (i, n - i - 1)
            // Avoid double counting the center element (when matrix size is odd)
            if (i != n - 1 - i) {
                sum += matrix[i][n - 1 - i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int matrix[][] = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                {13, 14, 15, 16 }
        };

        int result = diagonalSum(matrix);
        System.out.println("Diagonal Sum = " + result);
    }
}
