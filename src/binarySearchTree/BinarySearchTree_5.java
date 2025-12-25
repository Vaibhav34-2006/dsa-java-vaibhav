package binarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree_5 {

    // ---------- NODE CLASS ----------
    // Represents a single node of the Binary Search Tree
    static class Node {
        int data;        // value stored in the node
        Node left;       // reference to left child
        Node right;      // reference to right child

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

        // If value is smaller, insert in left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        // Otherwise, insert in right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root
        return root;
    }

    // ---------- INORDER TRAVERSAL ----------
    // Prints BST elements in sorted order
    public static void inorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Print current node
        System.out.print(root.data + " ");

        // Traverse right subtree
        inorder(root.right);
    }

    // ---------- PRINT PATH ----------
    // Prints a single root-to-leaf path
    public static void printPath(ArrayList<Integer> path) {

        // Traverse path list
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }

        // Print null at the end of path
        System.out.println("N");
    }

    // ---------- PRINT ROOT TO LEAF ----------
    // Prints all root-to-leaf paths in the tree
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {

        // Base case: if node is null
        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.data);

        // If leaf node is reached, print the path
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        // Recur for left subtree
        printRoot2Leaf(root.left, path);

        // Recur for right subtree
        printRoot2Leaf(root.right, path);

        // Remove last element (backtracking)
        path.remove(path.size() - 1);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Values to insert into BST
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        // Initially BST is empty
        Node root = null;

        // Insert values into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print inorder traversal
        inorder(root);
        System.out.println();

        // Print all root-to-leaf paths
        printRoot2Leaf(root, new ArrayList<>());
    }
}
