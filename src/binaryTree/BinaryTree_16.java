package binaryTree;

public class BinaryTree_16 {

    // ---------- NODE CLASS ----------
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- OPTIMIZED LCA ----------
    public static Node lca2(Node root, int n1, int n2) {

        // Base case
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // If one side is null, return the other
        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }

        // If both sides are non-null, current node is LCA
        return root;
    }

    // ---------- DISTANCE FROM ROOT TO NODE ----------
    public static int lcaDist(Node root, int n) {

        // Node not found
        if (root == null) {
            return -1;
        }

        // Target node found
        if (root.data == n) {
            return 0;
        }

        // Search in left and right subtree
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        // If node not found in both subtrees
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        // If found in right subtree
        else if (leftDist == -1) {
            return rightDist + 1;
        }
        // If found in left subtree
        else {
            return leftDist + 1;
        }
    }

    // ---------- MINIMUM DISTANCE ----------
    public static int minDist(Node root, int n1, int n2) {

        // Step 1: Find LCA
        Node lca = lca2(root, n1, n2);

        // Step 2: Distance from LCA to both nodes
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        // Step 3: Total distance
        return dist1 + dist2;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 7;

        System.out.println(minDist(root, n1, n2));
    }
}
