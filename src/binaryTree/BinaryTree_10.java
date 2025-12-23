package binaryTree;

public class BinaryTree_10 {

    // -------- NODE CLASS --------
    static class Node {
        int data;
        Node left, right;

        // Constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // -------- INFO CLASS --------
    // Stores both diameter and height
    static class Info {
        int diam;   // diameter of tree
        int ht;     // height of tree

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // -------- OPTIMIZED DIAMETER FUNCTION --------
    // Returns Info object containing diameter and height
    public static Info diameter(Node root) {

        // Base case: empty tree
        if (root == null) {
            return new Info(0, 0);
        }

        // Get info from left subtree
        Info leftInfo = diameter(root.left);

        // Get info from right subtree
        Info rightInfo = diameter(root.right);

        // Height of current node
        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        // Diameter passing through current node
        int selfDiam = leftInfo.ht + rightInfo.ht + 1;

        // Maximum diameter
        int diam = Math.max(selfDiam,
                   Math.max(leftInfo.diam, rightInfo.diam));

        // Return combined info
        return new Info(diam, height);
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

        // Create binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Calculate diameter
        Info result = diameter(root);

        // Print diameter
        System.out.println("Diameter of Binary Tree: " + result.diam);
    }
}
