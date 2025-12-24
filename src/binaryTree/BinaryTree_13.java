package binaryTree;

public class BinaryTree_13 {

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

    // ---------- PRINT Kth LEVEL ----------
    public static void KLevel(Node root, int level, int k) {

        // Base case: if tree is empty
        if (root == null) {
            return;
        }

        // If current level is equal to k, print node
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        // Recur for left subtree
        KLevel(root.left, level + 1, k);

        // Recur for right subtree
        KLevel(root.right, level + 1, k);
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

        int k = 2; // level to print

        KLevel(root, 0, k);
    }
}
