package binarySearchTree;

public class BinarySearchTree_8 {

    // ---------- NODE CLASS ----------
    // Represents a single node of the BST
    static class Node {
        int data;        // value stored in node
        Node left;       // left child reference
        Node right;      // right child reference

        // Constructor to initialize node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- CREATE BST FROM SORTED ARRAY ----------
    // Creates a height-balanced BST from a sorted array
    public static Node createBST(int arr[], int st, int end) {

        // Base case:
        // If start index crosses end index
        if (st > end) {
            return null;
        }

        // Find middle element
        int mid = (st + end) / 2;

        // Create root node using middle element
        Node root = new Node(arr[mid]);

        // Recursively create left subtree
        root.left = createBST(arr, st, mid - 1);

        // Recursively create right subtree
        root.right = createBST(arr, mid + 1, end);

        // Return root of subtree
        return root;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Sorted array
        int arr[] = {3, 5, 6, 8, 10, 11, 12};

        /*
                 Expected BST
                       8
                     /   \
                    5     11
                   / \   /  \
                  3   6 10  12
        */

        // Create BST from sorted array
        Node root = createBST(arr, 0, arr.length - 1);
    }
}
