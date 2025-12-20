package stack;

import java.util.Stack;

public class Stack_5 {

    // Method to reverse a string using Stack
    public static String reverseString(String str) {

        // Create a stack of Character type
        Stack<Character> s = new Stack<>();

        int idx = 0;

        // Push all characters of string into stack
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        // StringBuilder to store reversed string
        StringBuilder result = new StringBuilder("");

        // Pop characters from stack and append to result
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        // Return reversed string
        return result.toString();
    }

    public static void main(String[] args) {

        String str = "vaibhav";

        // Call reverseString method
        String result = reverseString(str);

        // Print reversed string
        System.out.println(result);
    }
}
