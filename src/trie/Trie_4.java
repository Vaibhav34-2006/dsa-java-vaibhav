package trie;

public class Trie_4 {

    // ---------- NODE CLASS ----------
    static class Node {
        // Each node has 26 children for characters a–z
        Node[] children = new Node[26];

        // End Of Word flag
        // true means a valid word ends here
        boolean eow = false;

        // Constructor initializes children as null
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // ---------- ROOT NODE ----------
    public static Node root = new Node();

    // Stores the final longest word
    public static String ans = "";

    // ---------- INSERT FUNCTION ----------
    // Inserts a word into the Trie
    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            // Create node if path does not exist
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // Move to next node
            curr = curr.children[idx];
        }

        // Mark end of word
        curr.eow = true;
    }

    // ---------- LONGEST WORD FUNCTION ----------
    // Finds the longest word such that all prefixes exist
    public static void longestWord(Node root, StringBuilder temp) {

        // Base case
        if (root == null) {
            return;
        }

        // Traverse children from 'a' to 'z'
        for (int i = 0; i < 26; i++) {

            // Move only if child exists AND forms a valid word
            if (root.children[i] != null && root.children[i].eow == true) {

                // Convert index to character
                char ch = (char) (i + 'a');

                // Add character to current word
                temp.append(ch);

                // Update answer if longer word found
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                // Recursive call
                longestWord(root.children[i], temp);

                // Backtracking: remove last character
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // Given words
        String[] words = {
                "a",
                "banana",
                "app",
                "appl",
                "ap",
                "apply",
                "apple"
        };

        // Insert words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Find longest word with all prefixes present
        longestWord(root, new StringBuilder(""));

        // Output result
        System.out.println(ans);   // apple
    }
}
