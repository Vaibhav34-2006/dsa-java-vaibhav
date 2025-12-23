package binaryTree;

public class BinaryTree_8 {

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

    // -------- SUM OF NODES FUNCTION --------
    // Returns sum of all node values in the binary tree
    public static int sum(Node root) {

        // Base case:
        // If tree/subtree is empty, sum is 0
        if (root == null) {
            return 0;
        }

        // Sum of left subtree
        int leftSum = sum(root.left);

        // Sum of right subtree
        int rightSum = sum(root.right);

        // Total sum = left sum + right sum + root value
        return leftSum + rightSum + root.data;
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

        // Print sum of all nodes in the binary tree
        System.out.println("Sum of nodes in Binary Tree: " + sum(root));
    }
}
