package leetcode;

public class Leetcode_22 {

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

    // Function to convert sorted array to height-balanced BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    // Helper function to build BST recursively
    private static TreeNode buildBST(int[] nums, int left, int right) {

        // Base case
        if (left > right) return null;

        // Choose middle element as root
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = buildBST(nums, left, mid - 1);

        // Build right subtree
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    // Inorder traversal to verify BST
    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        // Sample input (sorted array)
        int[] nums = {-10, -3, 0, 5, 9};

        // Convert to BST
        TreeNode root = sortedArrayToBST(nums);

        // Print inorder traversal (should be sorted)
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}