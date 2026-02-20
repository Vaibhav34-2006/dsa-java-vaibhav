package leetcode;

import java.util.Arrays;

public class Leetcode_20 {

    // Function to generate the next permutation
    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 2;

        // Step 1: find first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: find element just larger than nums[i] and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: reverse elements after index i
        reverse(nums, i + 1, n - 1);
    }

    // Swap helper
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse helper
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        // Sample test
        int[] nums = {1, 2, 3};

        nextPermutation(nums);

        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }
}