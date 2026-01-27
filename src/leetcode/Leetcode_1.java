package leetcode;

import java.util.HashMap;
import java.util.Arrays;

public class Leetcode_1 {

    public static int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store:
        // key: number in array
        // value: index of that number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse through the array once
        for (int i = 0; i < nums.length; i++) {

            // Find the number needed to reach the target
            // If nums[i] + needed = target
            int needed = target - nums[i];

            // Check if the needed number already exists in the map
            // If yes, we found the two indices
            if (map.containsKey(needed)) {
                return new int[] { map.get(needed), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
