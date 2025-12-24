package binaryTree;

public class BinaryTree_17 {

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

    // ---------- Kth ANCESTOR FUNCTION ----------
    public static int KAncestor(Node root, int n, int k) {

        // Base case: tree is empty
        if (root == null) {
            return -1;
        }

        // If target node is found
        if (root.data == n) {
            return 0;
        }

        // Search in left and right subtree
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        // If node not found in both subtrees
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // Get maximum distance from either subtree
        int max = Math.max(leftDist, rightDist);

        // If current node is kth ancestor
        if (max + 1 == k) {
            System.out.println(root.data);
        }

        // Return distance of current node from target
        return max + 1;
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

        int n = 5; // target node
        int k = 2; // kth ancestor

        KAncestor(root, n, k);
    }
}
