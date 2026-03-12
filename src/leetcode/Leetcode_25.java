package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_25 {

    // Definition for binary tree node
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

    // Function for postorder traversal (Left → Right → Root)
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    // Helper recursive function
    private static void postorder(TreeNode node, List<Integer> result) {

        if (node == null) return;

        // Traverse left subtree
        postorder(node.left, result);

        // Traverse right subtree
        postorder(node.right, result);

        // Visit root
        result.add(node.val);
    }

    public static void main(String[] args) {

        // Create tree:
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

        // Perform postorder traversal
        List<Integer> result = postorderTraversal(root);

        // Print result
        System.out.println("Postorder Traversal: " + result);
    }
}