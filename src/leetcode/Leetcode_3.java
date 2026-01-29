package leetcode;

import java.util.Arrays;

public class Leetcode_3 {

    // Function to remove all occurrences of val from array
    public static int removeElement(int[] nums, int val) {

        // Pointer to place next valid element
        int k = 0;

        // Traverse entire array
        for (int i = 0; i < nums.length; i++) {

            // If current element is NOT equal to val
            if (nums[i] != val) {

                // Move valid element to front
                nums[k] = nums[i];
                k++;
            }
        }

        // Return count of remaining elements
        return k;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        // Call function
        int k = removeElement(nums, val);

        // Print result
        System.out.println("Remaining count: " + k);

        // Print updated array (first k elements are valid)
        System.out.println("Updated array: " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
