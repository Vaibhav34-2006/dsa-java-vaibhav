package binarySearchTree;

public class BinarySearchTree_14 {

    // -------- NODE CLASS --------
    static class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1; // new node height = 1
        }
    }

    static Node root;

    // -------- HEIGHT --------
    static int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // -------- BALANCE FACTOR --------
    static int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // -------- RIGHT ROTATION --------
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // -------- LEFT ROTATION --------
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // -------- INSERT (for testing deletion) --------
    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // LL
        if (balance > 1 && key < root.left.data)
            return rightRotate(root);

        // RR
        if (balance < -1 && key > root.right.data)
            return leftRotate(root);

        // LR
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // -------- FIND MIN NODE --------
    static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // -------- AVL DELETE --------
    static Node deleteNode(Node root, int key) {

        // 1️⃣ Normal BST deletion
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteNode(root.left, key);

        else if (key > root.data)
            root.right = deleteNode(root.right, key);

        else {
            // node with one or no child
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            }
            // node with two children
            else {
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null)
            return root;

        // 2️⃣ Update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // 3️⃣ Get balance factor
        int balance = getBalance(root);

        // 4️⃣ Rotations

        // LL
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // -------- PREORDER TRAVERSAL --------
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.print("Before Deletion: ");
        preorder(root);

        root = deleteNode(root, 40);

        System.out.print("\nAfter Deletion: ");
        preorder(root);
    }
}
