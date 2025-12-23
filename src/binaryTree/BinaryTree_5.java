package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_5 {

    // -------- NODE CLASS --------
    // Each node contains:
    // data  -> value of node
    // left  -> reference to left child
    // right -> reference to right child
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // -------- BINARY TREE CLASS --------
    static class BinaryTree {

        // Index used while building tree
        static int idx = -1;

        // Build Binary Tree using preorder array
        // -1 represents NULL node
        public static Node buildTree(int nodes[]) {

            idx++;

            // Base case
            if (nodes[idx] == -1) {
                return null;
            }

            // Create new node
            Node newNode = new Node(nodes[idx]);

            // Build left subtree
            newNode.left = buildTree(nodes);

            // Build right subtree
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // -------- LEVEL ORDER TRAVERSAL --------
        // Traverses tree level by level
        public static void levelOrder(Node root) {

            // If tree is empty
            if (root == null) {
                return;
            }

            // Queue for BFS
            Queue<Node> q = new LinkedList<>();

            // Add root and level separator
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {

                Node currNode = q.remove();

                // If end of current level
                if (currNode == null) {
                    System.out.println();

                    // If queue is empty, traversal complete
                    if (q.isEmpty()) {
                        break;
                    } else {
                        // Add separator for next level
                        q.add(null);
                    }
                } 
                // If normal node
                else {
                    System.out.print(currNode.data + " ");

                    // Add left child
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    // Add right child
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int nodes[] = {
            1, 2, 4, -1, -1, 5, -1, -1,
            3, -1, 6, -1, -1
        };

        BinaryTree tree = new BinaryTree();

        // Build tree
        Node root = tree.buildTree(nodes);

        // Print level order traversal
        System.out.println("Level Order Traversal:");
        tree.levelOrder(root);
    }
}
