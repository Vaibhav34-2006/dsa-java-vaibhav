package stack;

import java.util.Stack;

public class stack_11 {

    // Function to calculate maximum rectangular area in histogram
    public static void maxArea(int arr[]) {

        int maxArea = 0;
        int nsr[] = new int[arr.length]; // Next Smaller Right
        int nsl[] = new int[arr.length]; // Next Smaller Left

        // -------------------- Next Smaller Right (NSR) --------------------
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            // Remove elements greater than or equal to current bar
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // If stack is empty → no smaller element on right
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }

            // Push current index
            s.push(i);
        }

        // -------------------- Next Smaller Left (NSL) --------------------
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements greater than or equal to current bar
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // If stack is empty → no smaller element on left
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            // Push current index
            s.push(i);
        }

        // -------------------- Calculate Max Area --------------------
        for (int i = 0; i < arr.length; i++) {

            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1; // width formula
            int currArea = height * width;

            maxArea = Math.max(currArea, maxArea);
        }

        // Print result
        System.out.println("Max area in histogram = " + maxArea);
    }

    public static void main(String[] args) {

        // Heights of histogram bars
        int arr[] = {2, 4};

        maxArea(arr);
    }
}
