package binarySearchTree;

public class BinarySearchTree_6 {

    // ---------- NODE CLASS ----------
    // Represents a single node of the Binary Search Tree
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

    // ---------- VALIDATE BST ----------
    // Checks whether a binary tree is a valid BST
    public static boolean isValidBST(Node root, Node min, Node max) {

        // Base case: empty tree is valid BST
        if (root == null) {
            return true;
        }

        // If current node violates min constraint
        if (min != null && root.data <= min.data) {
            return false;
        }

        // If current node violates max constraint
        else if (max != null && root.data >= max.data) {
            return false;
        }

        // Recursively validate left and right subtrees
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Values to insert into BST
        int values[] = {8, 5, 3, 6, 10, 11, 14};

        // Initially BST is empty
        Node root = null;

        // Insert values into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print inorder traversal
        inorder(root);
        System.out.println();

        // Check whether BST is valid
        if (isValidBST(root, null, null)) {
            System.out.println("valid");
        } else {
            System.out.println("not valid");
        }
    }
}
