package stack;

import java.util.Stack;

public class Stack_8 {

    public static void main(String[] args) {

        // Input array
        int arr[] = {6, 8, 0, 1, 3};

        // Stack to store indices of elements
        Stack<Integer> s = new Stack<>();

        // Array to store next greater elements
        int nxtGreater[] = new int[arr.length];

        // Traverse array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {

            // 1️⃣ Remove elements from stack that are
            // smaller than or equal to current element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2️⃣ If stack is empty, no greater element exists
            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            }
            // Otherwise, top of stack is the next greater element
            else {
                nxtGreater[i] = arr[s.peek()];
            }

            // 3️⃣ Push current index into stack
            s.push(i);
        }

        // Print Next Greater Element for each array element
        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
    }
}
