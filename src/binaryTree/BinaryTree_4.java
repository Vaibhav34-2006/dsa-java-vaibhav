package binaryTree;

public class BinaryTree_4 {

    // -------- NODE CLASS --------
    // Each node contains:
    // data  -> value of node
    // left  -> reference to left child
    // right -> reference to right child
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // -------- BINARY TREE CLASS --------
    static class BinaryTree {

        // Static index to track array position during tree construction
        static int idx = -1;

        // Method to build binary tree using preorder traversal
        // -1 represents NULL node
        public static Node buildTree(int nodes[]) {

            idx++; // move to next index in array

            // Base case: if value is -1, return null
            if (nodes[idx] == -1) {
                return null;
            }

            // Create new node with current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build left subtree
            newNode.left = buildTree(nodes);

            // Recursively build right subtree
            newNode.right = buildTree(nodes);

            // Return the constructed node
            return newNode;
        }

        // -------- PREORDER TRAVERSAL --------
        // Order: Root -> Left -> Right
        public static void preorder(Node root) {

            if (root == null) {
                return;
            }

            // Visit root
            System.out.print(root.data + " ");

            // Visit left subtree
            preorder(root.left);

            // Visit right subtree
            preorder(root.right);
        }

        // -------- INORDER TRAVERSAL --------
        // Order: Left -> Root -> Right
        public static void inorder(Node root) {

            if (root == null) {
                return;
            }

            // Visit left subtree
            inorder(root.left);

            // Visit root
            System.out.print(root.data + " ");

            // Visit right subtree
            inorder(root.right);
        }

        // -------- POSTORDER TRAVERSAL --------
        // Order: Left -> Right -> Root
        public static void postorder(Node root) {

            // Base case: if tree/subtree is empty
            if (root == null) {
                return;
            }

            // Step 1: Traverse left subtree
            postorder(root.left);

            // Step 2: Traverse right subtree
            postorder(root.right);

            // Step 3: Print root node
            System.out.print(root.data + " ");
        }
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        // Preorder representation of Binary Tree
        // -1 means no node
        int nodes[] = {
            1, 2, 4, -1, -1, 5, -1, -1,
            3, -1, 6, -1, -1
        };

        // Create BinaryTree object
        BinaryTree tree = new BinaryTree();

        // Build tree and get root node
        Node root = tree.buildTree(nodes);

        // Print root node data
        System.out.println("Root node data: " + root.data);

        // Print preorder traversal
        System.out.print("Preorder traversal: ");
        tree.preorder(root);

        System.out.println();

        // Print inorder traversal
        System.out.print("Inorder traversal: ");
        tree.inorder(root);

        System.out.println();

        // Print postorder traversal
        System.out.print("Postorder traversal: ");
        tree.postorder(root);
    }
}
