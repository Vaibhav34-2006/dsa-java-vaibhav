package trie;

public class Trie_1 {

    // ---------- NODE CLASS ----------
    // Each node represents one character
    static class Node {

        // Array to store children nodes for characters a–z
        Node[] children = new Node[26];

        // eow = End Of Word
        // true → a word ends at this node
        boolean eow = false;

        // Constructor
        // Initializes all children as null
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // ---------- ROOT NODE ----------
    // Root is the starting point of Trie
    public static Node root = new Node();

    // ---------- INSERT FUNCTION ----------
    // Inserts a word into the Trie
    public static void insert(String word) {

        // Start from root
        Node curr = root;

        // Traverse each character of the word
        for (int level = 0; level < word.length(); level++) {

            // Convert character to index (a=0, b=1, ..., z=25)
            int idx = word.charAt(level) - 'a';

            // If the path does not exist, create a new node
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // Move to the next node
            curr = curr.children[idx];
        }

        // After last character, mark end of word
        curr.eow = true;
    }

    // ---------- SEARCH FUNCTION ----------
    // Checks whether a word exists in the Trie
    public static boolean search(String key) {

        // Start from root
        Node curr = root;

        // Traverse each character of the key
        for (int level = 0; level < key.length(); level++) {

            // Convert character to index
            int idx = key.charAt(level) - 'a';

            // If character path does not exist → word not found
            if (curr.children[idx] == null) {
                return false;
            }

            // Move to next node
            curr = curr.children[idx];
        }

        // Word is found only if end-of-word flag is true
        return curr.eow == true;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Words to be inserted into Trie
        String[] words = {
            "the",
            "a",
            "there",
            "their",
            "any",
            "thee"
        };

        // Insert all words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Search operations
        System.out.println(search("the"));    // true
        System.out.println(search("there"));  // true
        System.out.println(search("their"));  // true
        System.out.println(search("any"));    // true
        System.out.println(search("an"));     // false
        System.out.println(search("th"));     // false
    }
}
