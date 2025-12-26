package binarySearchTree;

public class BinarySearchTree_13 {

    // ---------- NODE CLASS ----------
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1; // new node is initially added at leaf
        }
    }

    // Root of AVL Tree
    static Node root;

    // ---------- HEIGHT FUNCTION ----------
    static int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // ---------- GET BALANCE FACTOR ----------
    static int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // ---------- RIGHT ROTATION (LL Case) ----------
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // new root
    }

    // ---------- LEFT ROTATION (RR Case) ----------
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // new root
    }

    // ---------- INSERT FUNCTION ----------
    static Node insert(Node node, int key) {

        // Normal BST insertion
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else
            return node; // duplicates not allowed

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor
        int balance = getBalance(node);

        // ----- 4 AVL CASES -----

        // LL Case
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // ---------- PREORDER TRAVERSAL ----------
    static void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.print("Preorder traversal of AVL Tree: ");
        preorder(root);
    }
}
