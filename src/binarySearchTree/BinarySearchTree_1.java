package binarySearchTree;

public class BinarySearchTree_1 {

    // ---------- NODE CLASS ----------
    // Represents a single node of the BST
    static class Node {
        int data;       // value stored in the node
        Node left;      // reference to left child
        Node right;     // reference to right child

        // Constructor to initialize node data
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- INSERT FUNCTION ----------
    // Inserts a value into the BST and returns updated root
    public static Node insert(Node root, int val) {

        // Base case:
        // If tree is empty, create a new node
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If value is smaller than root, insert in left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        // Otherwise, insert in right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root pointer
        return root;
    }

    // ---------- INORDER TRAVERSAL ----------
    // Inorder traversal of BST prints values in sorted order
    public static void inorder(Node root) {

        // Base case:
        // If tree is empty, return
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left);

        // Print current node value
        System.out.print(root.data + " ");

        // Visit right subtree
        inorder(root.right);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Input values to insert into BST
        int values[] = {5, 1, 3, 4, 2, 7};

        // Initially tree is empty
        Node root = null;

        // Insert all values into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print BST using inorder traversal
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}
