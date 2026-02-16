package leetcode;

import java.util.Arrays;

public class Leetcode_17 {

    // Function to remove duplicates from sorted array
    public static int removeDuplicates(int[] nums) {

        // If array is empty, return 0
        if (nums.length == 0) return 0;

        // k keeps track of index for next unique element
        int k = 1;

        // Traverse array starting from second element
        for (int i = 1; i < nums.length; i++) {

            // If current element is different from previous
            if (nums[i] != nums[i - 1]) {

                // Place unique element at index k
                nums[k] = nums[i];
                k++;
            }
        }

        // k is count of unique elements
        return k;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 1, 2, 2, 3};

        // Remove duplicates
        int k = removeDuplicates(nums);

        // Print result count
        System.out.println("Unique count: " + k);

        // Print updated array (first k elements are valid)
        System.out.println("Updated array: " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}