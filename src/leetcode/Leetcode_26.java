package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_26 {

    // Function to find all unique triplets whose sum is 0
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Sort the array first
        Arrays.sort(nums);

        // Fix one number and find the other two using two pointers
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Two pointer search
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // If sum is 0, we found a triplet
                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate values for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

                // If sum is smaller than 0, move left pointer
                else if (sum < 0) {
                    left++;
                }

                // If sum is greater than 0, move right pointer
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Find triplets
        List<List<Integer>> result = threeSum(nums);

        // Print result
        System.out.println("3Sum Result: " + result);
    }
}