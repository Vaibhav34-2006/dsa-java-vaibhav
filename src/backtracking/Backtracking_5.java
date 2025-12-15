package backtracking;

public class Backtracking_5 {

    // Function to count number of ways to reach
    // bottom-right cell from top-left cell
    // Allowed moves: RIGHT and DOWN
    public static int gridWays(int i, int j, int n, int m) {

        // Base case 1:
        // If we reach the destination cell (n-1, m-1),
        // one valid path is found
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // Base case 2:
        // If we go outside the grid boundaries,
        // this path is invalid
        if (i == n || j == m) {
            return 0;
        }

        // Move DOWN (increase row index)
        int downWays = gridWays(i + 1, j, n, m);

        // Move RIGHT (increase column index)
        int rightWays = gridWays(i, j + 1, n, m);

        // Total ways from current cell
        return downWays + rightWays;
    }

    public static void main(String[] args) {

        int n = 3; // number of rows
        int m = 3; // number of columns

        // Start from top-left corner (0,0)
        int totalWays = gridWays(0, 0, n, m);

        System.out.println("Total number of ways = " + totalWays);
    }
}
