package arrays;

public class Array_19 {

    // Function to perform staircase search in a sorted 2D matrix
    public static boolean staircaseSearch(int matrix[][], int key) {

        int row = 0;                         // Start row
        int col = matrix[0].length - 1;      // Start from last column (top-right corner)

        // Search until row and col are within matrix bounds
        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == key) {   // Key found
                System.out.println("Key found at (" + row + ", " + col + ")");
                return true;

            } else if (key < matrix[row][col]) {
                col--;                        // Move left

            } else {
                row++;                        // Move down
            }
        }

        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {

        int matrix[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        int key = 33;

        staircaseSearch(matrix, key);
    }
}
