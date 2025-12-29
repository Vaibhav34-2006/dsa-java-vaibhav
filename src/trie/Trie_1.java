package trie;

public class Trie_1 {

    // ---------- Trie Node ----------
    static class Node {

        // Each node can have 26 children (a–z)
        Node[] children = new Node[26];

        // End Of Word flag
        // true → word ends here
        boolean eow = false;

        // Constructor
        Node() {
            // Initially, no child exists
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // ---------- Root of Trie ----------
    // Root does not store any character
    public static Node root = new Node();

    public static void main(String[] args) {
    	System.out.println("Trie initialized");
        // Trie initialization done
        // Words insertion & search will be added next
    }
}
