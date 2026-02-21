package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_21 {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Function for preorder traversal (Root -> Left -> Right)
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    // Helper recursive function
    private static void preorder(TreeNode node, List<Integer> result) {

        // Base case
        if (node == null) return;

        // Visit root
        result.add(node.val);

        // Traverse left subtree
        preorder(node.left, result);

        // Traverse right subtree
        preorder(node.right, result);
    }

    public static void main(String[] args) {

        // Create binary tree:
        //        1
        //         \
        //          2
        //         /
        //        3
        TreeNode root =
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                new TreeNode(3),
                                null));

        // Perform preorder traversal
        List<Integer> result = preorderTraversal(root);

        // Print result
        System.out.println("Preorder Traversal: " + result);
    }
}