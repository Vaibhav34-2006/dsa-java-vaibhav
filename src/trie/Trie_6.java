package trie;

import trie.Trie_1.Node;

public class Trie_6 {

    // ---------- NODE CLASS ----------
    static class Node {
        // Each node can have 26 children (a–z)
        Node[] children = new Node[26];

        // Constructor: initialize children as null
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

        
    }
    // ---------- COUNT NODES FUNCTION ----------
    // Counts total nodes in Trie (except root)
    public static int countNodes(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        int count = 0;

        // Traverse all possible children
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        // Count this node itself
        return count + 1;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        String str = "apple"; // Expected answer = 10

        // Insert all suffixes into Trie
        // apple, pple, ple, le, e
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        // Total distinct substrings = total nodes - 1 (exclude root)
        System.out.println(countNodes(root) - 1);
    }
}
