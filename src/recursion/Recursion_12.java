package recursion;

import java.util.Scanner;

public class Recursion_12 {

    // Recursive function to remove duplicates from a string
    public static void removeDuplicates(String str, int idx,
                                        StringBuilder newStr, boolean[] map) {

        // BASE CASE: if index reaches end → print the result
        if (idx == str.length()) {
            System.out.println("String after removing duplicates: " + newStr);
            return;
        }

        // Current character
        char currChar = str.charAt(idx);

        // If character already seen → skip it
        if (map[currChar - 'a']) {
            removeDuplicates(str, idx + 1, newStr, map);
        }
        else {
            // Mark character as seen
            map[currChar - 'a'] = true;

            // Add character to new string
            newStr.append(currChar);

            removeDuplicates(str, idx + 1, newStr, map);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();   // user input string

        boolean[] map = new boolean[26];   // visited array for letters a–z

        // Start recursion
        removeDuplicates(str, 0, new StringBuilder(""), map);

        sc.close();
    }
}
