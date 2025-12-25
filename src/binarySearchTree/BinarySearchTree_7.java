package binarySearchTree;

public class BinarySearchTree_7 {

    // ---------- NODE CLASS ----------
    // Represents a single node in the Binary Tree
    static class Node {
        int data;        // value stored in node
        Node left;       // left child reference
        Node right;      // right child reference

        // Constructor to initialize node
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // ---------- CREATE MIRROR ----------
    // Creates mirror of a binary tree (O(n))
    public static Node createMirror(Node root) {

        // Base case: if tree is empty
        if (root == null) {
            return null;
        }

        // Recursively create mirror of left subtree
        Node leftMirror = createMirror(root.left);

        // Recursively create mirror of right subtree
        Node rightMirror = createMirror(root.right);

        // Swap left and right children
        root.left = rightMirror;
        root.right = leftMirror;

        // Return root after mirroring
        return root;
    }

    // ---------- PREORDER TRAVERSAL ----------
    // Prints tree in preorder (Root → Left → Right)
    public static void preorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Print current node
        System.out.print(root.data + " ");

        // Traverse left subtree
        preorder(root.left);

        // Traverse right subtree
        preorder(root.right);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Creating tree manually
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        /*
                Original Tree
                     8
                    / \
                   5   10
                  / \    \
                 3   6    11
        */

        // Create mirror of the tree
        root = createMirror(root);

        /*
                Mirror Tree
                     8
                    / \
                  10   5
                  /   / \
                11   6   3
        */

        // Print preorder traversal of mirror tree
        preorder(root);
    }
}
