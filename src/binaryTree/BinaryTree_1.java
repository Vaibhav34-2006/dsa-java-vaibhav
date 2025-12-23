package binaryTree;

public class BinaryTree_1 {

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

        // Static index to track array position
        static int idx = -1;

        // Method to build binary tree using preorder traversal
        // -1 represents NULL node
        public static Node buildTree(int nodes[]) {

            idx++; // move to next index

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

            // Return constructed node
            return newNode;
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
    }
}
