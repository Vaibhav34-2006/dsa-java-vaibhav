package hashing;

import java.util.HashMap;

public class Hashing_8 {

    // -------- Function to check if two strings are anagrams --------
    public static boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // HashMap to store character frequency
        HashMap<Character, Integer> map = new HashMap<>();

        // -------- Count characters of first string --------
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // getOrDefault returns 0 if key not present
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // -------- Reduce count using second string --------
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If character not found, not an anagram
            if (!map.containsKey(ch)) {
                return false;
            }

            // If count becomes 1, remove character
            if (map.get(ch) == 1) {
                map.remove(ch);
            }
            // Otherwise decrease count
            else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        // If map is empty, strings are anagrams
        return map.isEmpty();
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        String s = "race";
        String t = "care";

        // Print result
        System.out.println(isAnagram(s, t)); // true
    }
}
