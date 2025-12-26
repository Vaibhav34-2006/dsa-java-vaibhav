package binarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree_12 {

    // ---------- NODE CLASS ----------
    // Represents a node of the BST
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

    // ---------- GET INORDER ----------
    // Stores inorder traversal of BST in ArrayList
    public static void getInorder(Node root, ArrayList<Integer> arr) {

        // Base case
        if (root == null) {
            return;
        }

        // Visit left subtree
        getInorder(root.left, arr);

        // Store current node data
        arr.add(root.data);

        // Visit right subtree
        getInorder(root.right, arr);
    }

    // ---------- MERGE BSTs ----------
    // Merges two BSTs into one balanced BST
    public static Node mergeBSTs(Node root1, Node root2) {

        // Step 1: get inorder of first BST
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // Step 2: get inorder of second BST
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 3: merge two sorted inorder lists
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        // Add remaining elements of arr2
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // Step 4: convert sorted ArrayList to balanced BST
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    // ---------- CREATE BST FROM SORTED ARRAYLIST ----------
    // Builds balanced BST using sorted list
    public static Node createBST(ArrayList<Integer> arr, int st, int end) {

        // Base case
        if (st > end) {
            return null;
        }

        // Find middle index
        int mid = (st + end) / 2;

        // Create root node
        Node root = new Node(arr.get(mid));

        // Create left subtree
        root.left = createBST(arr, st, mid - 1);

        // Create right subtree
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    // ---------- PREORDER TRAVERSAL ----------
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
              BST 1            BST 2
                2                4
               / \              / \
              1   4            3   6
        */

        // First BST
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // Second BST
        Node root2 = new Node(4);
        root2.left = new Node(3);
        root2.right = new Node(6);

        // Merge both BSTs
        Node root = mergeBSTs(root1, root2);

        // Print preorder of merged balanced BST
        preorder(root);
    }
}
