package leetcode;

public class Leetcode_18 {

    // Function to calculate trapped rain water
    public static int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        // Move pointers until they meet
        while (left < right) {

            // Work on the smaller height side
            if (height[left] <= height[right]) {

                // Update left maximum
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water trapped at this position
                    water += leftMax - height[left];
                }

                left++;
            } else {

                // Update right maximum
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water trapped at this position
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {

        // Sample input
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Calculate trapped water
        int result = trap(height);

        // Print result
        System.out.println("Trapped Water: " + result);
    }
}