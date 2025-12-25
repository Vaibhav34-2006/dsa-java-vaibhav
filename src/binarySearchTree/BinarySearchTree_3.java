package binarySearchTree;

public class BinarySearchTree_3 {

    // ---------- NODE CLASS ----------
    // Represents a single node in the Binary Search Tree
    static class Node {
        int data;          // value stored in the node
        Node left;         // left child reference
        Node right;        // right child reference

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

        // If value is greater, go to right subtree
        if (root.data < val) {
            root.right = insert(root.right, val);
        }
        // If value is smaller, go to left subtree
        else {
            root.left = insert(root.left, val);
        }

        // Return unchanged root
        return root;
    }

    // ---------- DELETE FUNCTION ----------
    // Deletes a node with given value from BST
    public static Node delete(Node root, int val) {

        // If value is greater, search in right subtree
        if (root.data < val) {
            root.right = delete(root.right, val);
        }

        // If value is smaller, search in left subtree
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }

        // Node to be deleted found
        else { // voila

            // ----- Case 1: Leaf node -----
            if (root.left == null && root.right == null) {
                return null;
            }

            // ----- Case 2: Single child -----
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // ----- Case 3: Both children -----
            // Find inorder successor
            Node IS = findInorderSuccessor(root.right);

            // Replace root data with inorder successor data
            root.data = IS.data;

            // Delete inorder successor
            root.right = delete(root.right, IS.data);
        }

        // Return updated root
        return root;
    }

    // ---------- INORDER SUCCESSOR ----------
    // Finds the smallest value in right subtree
    public static Node findInorderSuccessor(Node root) {

        // Move to the leftmost node
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // ---------- INORDER TRAVERSAL ----------
    // Prints BST in sorted order
    public static void inorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left);

        // Print node data
        System.out.print(root.data + " ");

        // Visit right subtree
        inorder(root.right);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Values to insert into BST
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        // BST initially empty
        Node root = null;

        // Insert values
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print inorder traversal before deletion
        inorder(root);
        System.out.println();

        // Delete node with value 1
        root = delete(root, 1);

        // Print inorder traversal after deletion
        inorder(root);
    }
}
