package stack;

import java.util.Stack;

public class Stack_10 {

    // Function to check duplicate parentheses in a string
    public static boolean isDuplicate(String str) {

        // Stack to store characters
        Stack<Character> s = new Stack<>();

        // Traverse each character of the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If closing bracket is found
            if (ch == ')') {
                int count = 0;

                // Pop elements until opening bracket '(' is found
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                // If no characters were between brackets → duplicate
                if (count < 1) {
                    return true; // duplicate parentheses found
                } else {
                    s.pop(); // remove the opening '('
                }
            } 
            // If opening bracket or any character
            else {
                s.push(ch);
            }
        }

        // No duplicate parentheses found
        return false;
    }

    public static void main(String[] args) {

        // Test cases
        String str1 = "((a+b))"; // true → duplicate parentheses
        String str2 = "(a-b)";   // false → no duplicate

        System.out.println(isDuplicate(str1));
        System.out.println(isDuplicate(str2));
    }
}
