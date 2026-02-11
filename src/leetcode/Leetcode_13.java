package leetcode;

import java.util.Arrays;

public class Leetcode_13 {

    // Function to reverse a character array in-place
    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        // Swap characters from both ends until they meet
        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        // Sample input
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        // Reverse the string
        reverseString(s);

        // Print result
        System.out.println("Reversed String: " + Arrays.toString(s));
    }
}
