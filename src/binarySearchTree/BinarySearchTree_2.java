package binarySearchTree;

public class BinarySearchTree_2 {

    // ---------- NODE CLASS ----------
    // Represents a single node of the Binary Search Tree
    static class Node {
        int data;       // Stores value of the node
        Node left;      // Reference to left child
        Node right;     // Reference to right child

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

        // If value is smaller than current node,
        // insert into left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        // Otherwise, insert into right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root node
        return root;
    }

    // ---------- SEARCH FUNCTION ----------
    // Searches for a given key in the BST
    public static boolean search(Node root, int key) {

        // Base case:
        // If tree is empty, key not found
        if (root == null) {
            return false;
        }

        // If current node data matches key
        if (root.data == key) {
            return true;
        }

        // If key is smaller than current node,
        // search in left subtree
        if (root.data > key) {
            return search(root.left, key);
        }
        // Else search in right subtree
        else {
            return search(root.right, key);
        }
    }

    // ---------- INORDER TRAVERSAL ----------
    // Prints BST elements in sorted order
    public static void inorder(Node root) {

        // Base case:
        // If tree is empty, return
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Print current node value
        System.out.print(root.data + " ");

        // Traverse right subtree
        inorder(root.right);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Values to insert into BST
        int values[] = {5, 1, 3, 4, 2, 7};

        // Initially BST is empty
        Node root = null;

        // Insert all values into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print BST using inorder traversal
        System.out.print("Inorder Traversal: ");
        inorder(root);
     // Search for value 1 in the BST
        if (search(root, 1)) {

            // If search() returns true, value is found
            System.out.println("found");

        } else {

            // If search() returns false, value is not found
            System.out.println("not found");
        }

    }
}
