package binaryTree;

import java.util.*;

public class BinaryTree_12 {

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

    // ---------- INFO CLASS ----------
    // Used to store node with its horizontal distance (hd)
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // ---------- TOP VIEW FUNCTION ----------
    public static void topView(Node root) {

        if (root == null) {
            return;
        }

        // Queue for level order traversal
        Queue<Info> q = new LinkedList<>();

        // Map to store first node at each horizontal distance
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        // Add root node with hd = 0
        q.add(new Info(root, 0));
        q.add(null); // level separator

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // Level finished
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } 
            else {
                // If hd not present, store node (topmost)
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                // Add left child
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                // Add right child
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        // Print top view from min to max horizontal distance
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
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

        topView(root);
    }
}
