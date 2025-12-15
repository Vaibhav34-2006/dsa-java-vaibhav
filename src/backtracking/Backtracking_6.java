package backtracking;

public class Backtracking_6 {

    // Function to solve the Sudoku using backtracking
    public static boolean solveSudoku(int board[][]) {

        // Variables to store row and column of an empty cell
        int row = -1, col = -1;

        // Flag to check if an empty cell is found
        boolean emptyFound = false;

        // Step 1: Search for an empty cell (value = 0)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {     // empty cell found
                    row = i;
                    col = j;
                    emptyFound = true;
                    break;
                }
            }
            if (emptyFound) break;
        }

        // Step 2: Base case
        // If no empty cell is found, Sudoku is solved
        if (!emptyFound) {
            return true;
        }

        // Step 3: Try numbers from 1 to 9 in the empty cell
        for (int num = 1; num <= 9; num++) {

            // Check if placing 'num' is safe
            if (isSafe(board, row, col, num)) {

                // Place the number
                board[row][col] = num;

                // Recursively solve the remaining board
                if (solveSudoku(board)) {
                    return true;    // solution found
                }

                // Backtrack: remove the number if it doesn't lead to solution
                board[row][col] = 0;
            }
        }

        // Step 4: No number fits, return false
        return false;
    }

    // Function to check whether a number can be placed safely
    public static boolean isSafe(int board[][], int row, int col, int num) {

        // Check the entire row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check the entire column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Find starting row and column of the 3×3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        // Check the 3×3 sub-grid
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        // If number is safe in row, column and sub-grid
        return true;
    }

    // Function to print the Sudoku board
    public static void printBoard(int board[][]) {

        // Loop through each row
        for (int i = 0; i < 9; i++) {

            // Loop through each column
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Sudoku board (0 represents empty cells)
        int board[][] = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        // Solve the Sudoku
        solveSudoku(board);

        // Print the solved Sudoku board
        printBoard(board);
    }
}
