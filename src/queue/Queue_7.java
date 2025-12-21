package queue;

import java.util.*; // Import Queue, LinkedList, etc.

public class Queue_7 {

    // Method to print first non-repeating character at each step
    public static void printNonRepeating(String str) {

        // Frequency array for characters 'a' to 'z'
        int freq[] = new int[26];

        // Queue to store characters in order of appearance
        Queue<Character> q = new LinkedList<>();

        // Traverse the string character by character
        for (int i = 0; i < str.length(); i++) {

            // Get current character
            char ch = str.charAt(i);

            // Add character to queue
            q.add(ch);

            // Increase frequency count
            freq[ch - 'a']++;

            // Remove characters from queue if they are repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // If queue becomes empty, no non-repeating character exists
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            }
            // Otherwise, front of queue is first non-repeating character
            else {
                System.out.print(q.peek() + " ");
            }
        }

        // Move to next line after output
        System.out.println();
    }

    public static void main(String[] args) {

        // Input string
        String str = "aabccxb";

        // Call method
        printNonRepeating(str);
    }
}
