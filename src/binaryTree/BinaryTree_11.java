package binaryTree;

public class BinaryTree_11 {

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

    // ---------- CHECK IF TWO TREES ARE IDENTICAL ----------
    public static boolean isIdentical(Node node, Node subRoot) {

        // Case 1: both nodes are null → identical
        if (node == null && subRoot == null) {
            return true;
        }

        // Case 2: one is null or data mismatch → not identical
        if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        // Recursively check left and right subtree
        return isIdentical(node.left, subRoot.left) &&
               isIdentical(node.right, subRoot.right);
    }

    // ---------- CHECK IF SUBTREE EXISTS ----------
    public static boolean isSubtree(Node root, Node subRoot) {

        // If main tree becomes null → subtree not found
        if (root == null) {
            return false;
        }

        // If current node data matches subtree root
        if (root.data == subRoot.data) {
            // Check if the trees are identical from this node
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Otherwise check in left or right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        /*
                Main Tree
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

        /*
                Subtree
                   2
                 /   \
                4     5
        */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // Function call
        System.out.println(isSubtree(root, subRoot)); // true
    }
}
