package trie;

public class Trie_5 {

    // ---------- NODE CLASS ----------
    static class Node {
        // Each node has 26 children (a–z)
        Node[] children = new Node[26];

        // Marks end of a complete word
        boolean eow = false;

        // Constructor
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // ---------- ROOT NODE ----------
    public static Node root = new Node();

    // ---------- INSERT FUNCTION ----------
    // Inserts a word into the Trie
    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            // Create node if missing
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // Move to next character
            curr = curr.children[idx];
        }

        // Mark end of word
        curr.eow = true;
    }

    // ---------- STARTS WITH FUNCTION ----------
    // Checks if any word in Trie starts with given prefix
    // Time Complexity: O(L), where L = length of prefix
    public static boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            // If prefix path breaks → false
            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        // All prefix characters found
        return true;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        String[] words = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";    // true
        String prefix2 = "moon";   // false

        // Insert words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Test prefixes
        System.out.println(startsWith(prefix1)); // true
        System.out.println(startsWith(prefix2)); // false
    }
}
