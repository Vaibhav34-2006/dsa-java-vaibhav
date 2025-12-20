package stack;

import java.util.Stack;

public class Stack_9 {

    // Function to check whether the given string has valid parentheses
    public static boolean isValid(String str) {

        // Stack to store opening brackets
        Stack<Character> s = new Stack<>();

        // Traverse each character of the string
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // If opening bracket, push into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } 
            // If closing bracket
            else {

                // If stack is empty, no matching opening bracket
                if (s.isEmpty()) {
                    return false;
                }

                // Check if top of stack matches the closing bracket
                if ((s.peek() == '(' && ch == ')') ||   // ()
                    (s.peek() == '{' && ch == '}') ||   // {}
                    (s.peek() == '[' && ch == ']')) {   // []

                    // Valid pair found, remove opening bracket
                    s.pop();
                } 
                // Mismatched bracket
                else {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets are matched
        return s.isEmpty();
    }

    public static void main(String[] args) {

        // Test string
        String str = "({})[]";   // true

        // Print result
        System.out.println(isValid(str));
    }
}
