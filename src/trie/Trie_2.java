package trie;

public class Trie_2 {

    // ================= NODE CLASS =================
    // Each node represents one character in the Trie
    static class Node {

        // Array of size 26 for characters a–z
        Node[] children = new Node[26];

        // eow = End Of Word
        // true means a complete word ends here
        boolean eow = false;

        // Constructor: initialize all children as null
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // ================= ROOT NODE =================
    // Root is the starting point of Trie
    public static Node root = new Node();

    // ================= INSERT FUNCTION =================
    // Inserts a word into the Trie
    public static void insert(String word) {

        Node curr = root; // start from root

        // Go through each character of the word
        for (int level = 0; level < word.length(); level++) {

            // Convert character into index (a=0, b=1, ..., z=25)
            int idx = word.charAt(level) - 'a';

            // If path does not exist, create new node
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // Move to the next node
            curr = curr.children[idx];
        }

        // After inserting full word, mark end of word
        curr.eow = true;
    }

    // ================= SEARCH FUNCTION =================
    // Checks whether a word exists in Trie
    public static boolean search(String key) {

        Node curr = root;

        // Traverse Trie according to characters of key
        for (int level = 0; level < key.length(); level++) {

            int idx = key.charAt(level) - 'a';

            // If path breaks, word does not exist
            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        // Word exists only if end-of-word flag is true
        return curr.eow == true;
    }

    // ================= WORD BREAK FUNCTION =================
    // Checks if the string can be broken into valid dictionary words
    public static boolean wordBreak(String key) {

        // Base case:
        // If string becomes empty, it means successful break
        if (key.length() == 0) {
            return true;
        }

        // Try all possible prefixes
        for (int i = 1; i <= key.length(); i++) {

            // Check:
            // 1) prefix exists in Trie
            // 2) remaining string can also be broken
            if (search(key.substring(0, i)) &&
                wordBreak(key.substring(i))) {
                return true;
            }
        }

        // If no valid break found
        return false;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        // Dictionary words
        String arr[] = {
            "i", "like", "sam", "samsung", "mobile", "ice"
        };

        // Insert all dictionary words into Trie
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        // Given string to check
        String key = "ilikesamsung";

        // Print result
        System.out.println(wordBreak(key)); // true
    }
}
