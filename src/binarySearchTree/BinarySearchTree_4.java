package binarySearchTree;

public class BinarySearchTree_4 {

    // ---------- NODE CLASS ----------
    // Represents a single node in the Binary Search Tree
    static class Node {
        int data;          // value stored in the node
        Node left;         // reference to left child
        Node right;        // reference to right child

        // Constructor to initialize node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- INSERT FUNCTION ----------
    // Inserts a value into the BST
    public static Node insert(Node root, int val) {

        // If tree is empty, create new node
        if (root == null) {
            return new Node(val);
        }

        // If value is smaller, go to left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        // Otherwise, go to right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root
        return root;
    }

    // ---------- INORDER TRAVERSAL ----------
    // Prints BST elements in sorted order
    public static void inorder(Node root) {

        // Base case: if tree is empty
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left);

        // Print current node data
        System.out.print(root.data + " ");

        // Visit right subtree
        inorder(root.right);
    }

    // ---------- PRINT IN RANGE ----------
    // Prints all nodes whose values lie between k1 and k2 (inclusive)
    public static void printInRange(Node root, int k1, int k2) {

        // Base case: if tree is empty
        if (root == null) {
            return;
        }

        // If current node lies within range
        if (root.data >= k1 && root.data <= k2) {

            // Check left subtree
            printInRange(root.left, k1, k2);

            // Print current node
            System.out.print(root.data + " ");

            // Check right subtree
            printInRange(root.right, k1, k2);
        }

        // If current node value is smaller than k1,
        // search only in right subtree
        else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        }

        // If current node value is greater than k2,
        // search only in left subtree
        else {
            printInRange(root.right, k1, k2);
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Values to insert into BST
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        // BST initially empty
        Node root = null;

        // Insert values into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print inorder traversal
        inorder(root);
        System.out.println();

        // Print nodes within range [5, 12]
        printInRange(root, 5, 12);
    }
}
