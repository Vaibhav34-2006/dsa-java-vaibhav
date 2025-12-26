package binarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree_9 {

    // ---------- NODE CLASS ----------
    // Represents a single node of the BST
    static class Node {
        int data;        // value stored in node
        Node left;       // left child
        Node right;      // right child

        // Constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- GET INORDER ----------
    // Stores inorder traversal of BST into ArrayList
    public static void getInorder(Node root, ArrayList<Integer> inorder) {

        // Base case
        if (root == null) {
            return;
        }

        // Visit left subtree
        getInorder(root.left, inorder);

        // Store current node value
        inorder.add(root.data);

        // Visit right subtree
        getInorder(root.right, inorder);
    }

    // ---------- CREATE BALANCED BST ----------
    // Creates balanced BST from sorted inorder list
    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {

        // Base case
        if (st > end) {
            return null;
        }

        // Find middle index
        int mid = (st + end) / 2;

        // Create root using middle element
        Node root = new Node(inorder.get(mid));

        // Build left subtree
        root.left = createBST(inorder, st, mid - 1);

        // Build right subtree
        root.right = createBST(inorder, mid + 1, end);

        // Return root
        return root;
    }

    // ---------- BALANCE BST ----------
    // Converts an unbalanced BST into a balanced BST
    public static Node balanceBST(Node root) {

        // Step 1: Store inorder traversal (sorted sequence)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // Step 2: Create balanced BST from sorted inorder
        root = createBST(inorder, 0, inorder.size() - 1);

        return root;
    }

    // ---------- PREORDER ----------
    // Prints preorder traversal
    public static void preorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Print root
        System.out.print(root.data + " ");

        // Visit left subtree
        preorder(root.left);

        // Visit right subtree
        preorder(root.right);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        /*
               Given BST
                     8
                    / \
                   6   10
                  /      \
                 5        11
                /           \
               3             12
        */

        // Manually creating unbalanced BST
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
               Expected Balanced BST
                     8
                    / \
                   5   11
                  / \  / \
                 3  6 10 12
        */

        // Balance the BST
        root = balanceBST(root);

        // Print preorder traversal of balanced BST
        preorder(root);
    }
}
