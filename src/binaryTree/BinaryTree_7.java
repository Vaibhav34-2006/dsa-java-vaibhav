package binaryTree;

public class BinaryTree_7 {

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

    // -------- COUNT NODES FUNCTION --------
    // Returns total number of nodes in the binary tree
    public static int count(Node root) {

        // Base case:
        // If tree/subtree is empty, count is 0
        if (root == null) {
            return 0;
        }

        // Count nodes in left subtree
        int leftCount = count(root.left);

        // Count nodes in right subtree
        int rightCount = count(root.right);

        // Total nodes = left + right + root(1)
        return leftCount + rightCount + 1;
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

        // Print total number of nodes in the binary tree
        System.out.println("Total nodes in Binary Tree: " + count(root));
    }
}
