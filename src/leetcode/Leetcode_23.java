package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_23 {

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

    // Function to perform level order traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) return result;

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Traverse level by level
        while (!queue.isEmpty()) {

            int size = queue.size();           // nodes in current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Add current node value
                level.add(node.val);

                // Add children to queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add current level to result
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

        // Create binary tree:
        //        3
        //       / \
        //      9  20
        //         / \
        //        15  7
        TreeNode root =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)));

        // Perform level order traversal
        List<List<Integer>> result = levelOrder(root);

        // Print result
        System.out.println("Level Order Traversal: " + result);
    }
}