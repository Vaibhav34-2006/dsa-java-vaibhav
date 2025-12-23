package binaryTree;

public class BinaryTree_6 {

    // -------- NODE CLASS --------
    // Each node contains:
    // data  -> value of the node
    // left  -> reference to left child
    // right -> reference to right child
    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize node
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // -------- HEIGHT FUNCTION --------
    // Height of a Binary Tree:
    // Number of nodes on the longest path from root to a leaf
    public static int height(Node root) {

        // Base case:
        // If tree/subtree is empty, height is 0
        if (root == null) {
            return 0;
        }

        // Calculate height of left subtree
        int lh = height(root.left);

        // Calculate height of right subtree
        int rh = height(root.right);

        // Height of tree = max(left height, right height) + 1 (root node)
        return Math.max(lh, rh) + 1;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        // Manually creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Print height of the binary tree
        System.out.println("Height of Binary Tree: " + height(root));
    }
}
