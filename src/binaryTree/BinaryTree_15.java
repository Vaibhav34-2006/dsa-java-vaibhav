package binaryTree;

public class BinaryTree_15 {

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

    // ---------- OPTIMIZED LCA FUNCTION ----------
    public static Node lca2(Node root, int n1, int n2) {

        // Base case:
        // if root is null or root matches n1 or n2
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Find LCA in left subtree
        Node leftLca = lca2(root.left, n1, n2);

        // Find LCA in right subtree
        Node rightLca = lca2(root.right, n1, n2);

        // If one side is null, return the other side
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        // If both sides are non-null, current node is LCA
        return root;
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

        int n1 = 4, n2 = 7;

        System.out.println(lca2(root, n1, n2).data);
    }
}
