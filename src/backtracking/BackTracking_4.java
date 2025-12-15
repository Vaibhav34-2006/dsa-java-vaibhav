package backtracking;

public class BackTracking_4 {

    static int count = 0;           // counts total solutions
    static boolean printOne = true; // true = one solution, false = all solutions

    // Check if queen can be placed safely
    public static boolean isSafe(char board[][], int row, int col) {

        // Check same column (upwards)
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal (upwards)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal (upwards)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // N-Queens backtracking function
    public static boolean nQueens(char board[][], int row) {

        // Base case: all queens placed
        if (row == board.length) {
            count++;
            printBoard(board);

            // Stop after one solution if required
            if (printOne) return true;

            return false; // continue for all solutions
        }

        // Try all columns in current row
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';  // place queen

                boolean found = nQueens(board, row + 1);

                board[row][col] = 'X';  // backtrack

                if (printOne && found) return true;
            }
        }

        return false;
    }

    // Print chessboard
    public static void printBoard(char board[][]) {
        System.out.println("---- Solution ----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int N = 5;  // Change N as needed
        char board[][] = new char[N][N];

        // Initialize board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 'X';
            }
        }

        //  MODE SELECTION
        printOne = true;   // true → print only ONE solution
        // printOne = false; // false → print ALL solutions

        boolean solved = nQueens(board, 0);

        if (!solved && count == 0) {
            System.out.println("No solution exists for N = " + N);
        }

        System.out.println("Total solutions = " + count);
    }
}
