package arraylist;
import java.util.*;

public class Arraylist_11 {

    // Optimized function using Two Pointer Approach
    public static int storewater(ArrayList<Integer> height) {

        // Left pointer at start
        int left = 0;

        // Right pointer at end
        int right = height.size() - 1;

        // Variable to store maximum water
        int maxWater = 0;

        // Loop until both pointers meet
        while (left < right) {

            // Height of water = minimum of two pointers
            int ht = Math.min(height.get(left), height.get(right));

            // Width between two pointers
            int width = right - left;

            // Water stored
            int currWater = ht * width;

            // Update maximum water
            maxWater = Math.max(maxWater, currWater);

            // Move the pointer having smaller height
            if (height.get(left) < height.get(right)) {
                left++;     // Move left pointer right
            } else {
                right--;    // Move right pointer left
            }
        }

        // Return the maximum water found
        return maxWater;
    }

    public static void main(String[] args) {

        // Create ArrayList of heights
        ArrayList<Integer> height = new ArrayList<>();

        // Add values
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Print result
        System.out.println(storewater(height));
    }
}
