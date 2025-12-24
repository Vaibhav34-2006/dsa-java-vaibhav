package binaryTree;

public class BinaryTree_18 {

    // ---------- NODE CLASS ----------
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------- PREORDER TRAVERSAL ----------
    public static void preorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Root → Left → Right
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // ---------- TRANSFORM TO SUM TREE ----------
    public static int transform(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Recursively transform left and right subtree
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        // Store original value before changing
        int originalData = root.data;

        // Get current left and right node values
        int leftData = (root.left == null) ? 0 : root.left.data;
        int rightData = (root.right == null) ? 0 : root.right.data;

        // Update current node to sum of left and right subtree
        root.data = leftData + leftChild + rightData + rightChild;

        // Return original value to parent
        return originalData;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Transform tree to sum tree
        transform(root);

        // Print preorder traversal of sum tree
        preorder(root);
    }
}
