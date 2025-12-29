package trie;

public class Trie_3 {

    // ---------- NODE CLASS ----------
    static class Node {

        // Stores links to next characters (a–z)
        Node[] children = new Node[26];

        // Frequency = how many words pass through this node
        int freq;

        // Constructor
        Node() {
            // Initialize all children as null
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            // When a node is created, frequency starts from 1
            freq = 1;
        }
    }

    // ---------- ROOT NODE ----------
    static Node root = new Node();

    // ---------- INSERT WORD INTO TRIE ----------
    public static void insert(String word) {

        Node curr = root;

        // Traverse each character of the word
        for (int i = 0; i < word.length(); i++) {

            // Convert character into index (0–25)
            int idx = word.charAt(i) - 'a';

            // If path does not exist, create new node
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            // If node already exists, increase frequency
            else {
                curr.children[idx].freq++;
            }

            // Move to next node
            curr = curr.children[idx];
        }
    }

    // ---------- FIND SHORTEST UNIQUE PREFIX ----------
    public static void findPrefix(Node node, String prefix) {

        // Base case
        if (node == null) {
            return;
        }

        // If frequency becomes 1, prefix is unique
        if (node.freq == 1) {
            System.out.println(prefix);
            return;
        }

        // Explore all children
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                findPrefix(node.children[i],
                        prefix + (char)(i + 'a'));
            }
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Given words
        String[] words = {"zebra", "dog", "duck", "dove"};

        // Insert all words into Trie
        for (String word : words) {
            insert(word);
        }

        // Root frequency is ignored
        root.freq = -1;

        // Print shortest unique prefix for each word
        findPrefix(root, "");
    }
}
