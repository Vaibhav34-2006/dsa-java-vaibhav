package graph;

public class Graph_20 {

    // ---------- HELPER FUNCTION ----------
    // This function performs DFS to fill connected pixels
    // image  → given 2D image
    // sr, sc → current row & column
    // color  → new color to fill
    // vis    → visited array
    // orgCol → original color at starting pixel
    // Time Complexity: O(m * n)
    public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {

        // Base conditions:
        // 1. Out of bounds
        // 2. Already visited
        // 3. Current pixel color is not original color
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // Mark current cell as visited
        vis[sr][sc] = true;

        // Change the color of current pixel
        image[sr][sc] = color;

        // Move to left
        helper(image, sr, sc - 1, color, vis, orgCol);

        // Move to right
        helper(image, sr, sc + 1, color, vis, orgCol);

        // Move up
        helper(image, sr - 1, sc, color, vis, orgCol);

        // Move down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    // ---------- FLOOD FILL FUNCTION ----------
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // Visited array to avoid revisiting cells
        boolean vis[][] = new boolean[image.length][image[0].length];

        // Call DFS helper with original color
        helper(image, sr, sc, color, vis, image[sr][sc]);

        // Return updated image
        return image;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
    }
}

