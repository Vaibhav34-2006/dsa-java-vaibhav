package trie;

public class Trie_1 {

    // ---------- NODE CLASS ----------
    static class Node {
        // Each node has 26 children (a–z)
        Node[] children = new Node[26];

        // End Of Word flag
        boolean eow = false;

        // Constructor to initialize children as null
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // ---------- ROOT NODE ----------
    public static Node root = new Node();

    // ---------- INSERT FUNCTION ----------
    public static void insert(String word) {

        Node curr = root;

        for (int level = 0; level < word.length(); level++) {

            // Convert character to index (0–25)
            int idx = word.charAt(level) - 'a';

            // If node does not exist, create it
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // Move to next node
            curr = curr.children[idx];
        }

        // Mark end of word
        curr.eow = true;
    }

    // ---------- SEARCH FUNCTION ----------
    public static boolean search(String key) {

        Node curr = root;

        for (int level = 0; level < key.length(); level++) {

            int idx = key.charAt(level) - 'a';

            // If character path not found
            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        // Word exists only if end-of-word is true
        return curr.eow == true;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Words to insert
        String[] words = {
            "the",
            "a",
            "there",
            "their",
            "any",
            "thee"
        };

        // Insert words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Search test cases
        System.out.println(search("the"));    // true
        System.out.println(search("there"));  // true
        System.out.println(search("their"));  // true
        System.out.println(search("any"));    // true
        System.out.println(search("an"));     // false
        System.out.println(search("th"));     // false
    }
}
