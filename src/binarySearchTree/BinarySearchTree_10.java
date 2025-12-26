package binarySearchTree;

public class BinarySearchTree_10 {

    // ---------- NODE CLASS ----------
    // Represents a node of the Binary Tree
    static class Node {
        int data;          // value of node
        Node left;         // left child
        Node right;        // right child

        // Constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- INFO CLASS ----------
    // Stores information about subtree
    static class Info {
        boolean isBST;     // tells whether subtree is BST
        int size;          // size of subtree
        int min;           // minimum value in subtree
        int max;           // maximum value in subtree

        // Constructor
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Stores size of largest BST found so far
    public static int maxBST = 0;

    // ---------- LARGEST BST ----------
    // Returns Info object for each subtree
    public static Info largestBST(Node root) {

        // Base case: empty tree is a BST of size 0
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Get info from left subtree
        Info leftInfo = largestBST(root.left);

        // Get info from right subtree
        Info rightInfo = largestBST(root.right);

        // Current subtree size
        int size = leftInfo.size + rightInfo.size + 1;

        // Minimum value in current subtree
        int min = Math.min(root.data,
                Math.min(leftInfo.min, rightInfo.min));

        // Maximum value in current subtree
        int max = Math.max(root.data,
                Math.max(leftInfo.max, rightInfo.max));

        // If BST property is violated
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // If left and right subtrees are BST
        if (leftInfo.isBST && rightInfo.isBST) {

            // Update largest BST size
            maxBST = Math.max(maxBST, size);

            return new Info(true, size, min, max);
        }

        // Otherwise, not a BST
        return new Info(false, size, min, max);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        /*
                 Given Binary Tree
                         50
                       /    \
                     30      60
                    /  \    /  \
                   5   20  45   70
                               / \
                              65  80
        */

        // Constructing the given binary tree
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        // Find largest BST in the given Binary Tree
        largestBST(root);

        // Print size of largest BST
        System.out.println(maxBST);
    }
}
