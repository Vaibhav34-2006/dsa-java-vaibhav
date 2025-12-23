package binaryTree;

public class BinaryTree_9 {

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
    // Returns height of the binary tree
    public static int height(Node root) {

        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // Height of left subtree
        int lh = height(root.left);

        // Height of right subtree
        int rh = height(root.right);

        // Height = max(left, right) + 1 (current node)
        return Math.max(lh, rh) + 1;
    }

    // -------- DIAMETER FUNCTION --------
    // Diameter = number of nodes on the longest path between any two nodes
    // This is the O(n^2) approach
    public static int diameter(Node root) {

        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // Diameter of left subtree
        int leftDiam = diameter(root.left);

        // Height of left subtree
        int leftHt = height(root.left);

        // Diameter of right subtree
        int rightDiam = diameter(root.right);

        // Height of right subtree
        int rightHt = height(root.right);

        // Diameter passing through current root
        int selfDiam = leftHt + rightHt + 1;

        // Return maximum of all three
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
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

        // Print diameter of the binary tree
        System.out.println("Diameter of Binary Tree: " + diameter(root));
    }
}
